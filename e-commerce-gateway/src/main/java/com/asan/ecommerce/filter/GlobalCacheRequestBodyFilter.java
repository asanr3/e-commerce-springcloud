package com.asan.ecommerce.filter;

import com.asan.ecommerce.constant.GatewayConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <h1>缓存请求 body 的全局过滤器</h1>
 * <p>因为登录或注册需要提供用户名和密码，而这样的请求是post请求，但是在filter里面是拿不到post里面的数据的，所以需要一个过滤器将请求的数据缓存下来，
 * 在另一个过滤器（登录、注册、鉴权全局过滤器）才能拿到这些数据，为登录、注册、鉴权全局过滤器做准备</p>
 * Spring WebFlux
 *
 * @author mingkai yun
 * @date 2022/1/14
 */
@Slf4j
@Component
@SuppressWarnings("all")
public class GlobalCacheRequestBodyFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 判断请求是否是登录或是注册
        boolean isloginOrRegister =
                exchange.getRequest().getURI().getPath().contains(GatewayConstant.LOGIN_URI)
                        || exchange.getRequest().getURI().getPath().contains(GatewayConstant.REGISTER_URI);
        // 如果请求头类型为空 或 不是登录/注册 则不做缓存
        if (null == exchange.getRequest().getHeaders().getContentType()
                || !isloginOrRegister) {
            return chain.filter(exchange);
        }

        // DataBufferUtils.join 拿到请求中的数据 --> DataBuffer
        return DataBufferUtils.join(exchange.getRequest().getBody()).flatMap(dataBuffer -> {

            // 确保数据缓冲区不被释放, 必须要 DataBufferUtils.retain
            DataBufferUtils.retain(dataBuffer);
            // defer、just 都是去创建数据源, 得到当前数据的副本
            Flux<DataBuffer> cachedFlux = Flux.defer(() ->
                    Flux.just(dataBuffer.slice(0, dataBuffer.readableByteCount())));
            // 重新包装 ServerHttpRequest, 重写 getBody 方法, 能够返回请求数据
            ServerHttpRequest mutatedRequest =
                    new ServerHttpRequestDecorator(exchange.getRequest()) {
                        @Override
                        public Flux<DataBuffer> getBody() {
                            return cachedFlux;
                        }
                    };
            // 将包装之后的 ServerHttpRequest 向下继续传递
            return chain.filter(exchange.mutate().request(mutatedRequest).build());
        });
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE + 1;
    }
}
