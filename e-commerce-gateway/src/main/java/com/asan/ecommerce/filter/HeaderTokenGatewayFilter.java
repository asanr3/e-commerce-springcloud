package com.asan.ecommerce.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <h1>HTTP 请求头部携带 Token 验证过滤器</h1>
 *
 * @author mingkai yun
 * @date 2022/1/14
 */
public class HeaderTokenGatewayFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 从 HTTP Header 中寻找 key 为 token, value 为 asan 的键值对
        String name = exchange.getRequest().getHeaders().getFirst("token");
        if ("asan".equals(name)) {
            return chain.filter(exchange);
        }

        // 标记此次请求没有权限, 并结束这次请求
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        //  设置Order，将最高优先级 +2，使其不是最高优先级
        return HIGHEST_PRECEDENCE + 2;
    }
}
