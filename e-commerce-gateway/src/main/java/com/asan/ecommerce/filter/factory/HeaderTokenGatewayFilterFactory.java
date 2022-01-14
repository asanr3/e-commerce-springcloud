package com.asan.ecommerce.filter.factory;

import com.asan.ecommerce.filter.HeaderTokenGatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * <h1>请求头部携带 Token 验证过滤器 工厂类</h1>
 * @author mingkai yun
 * @date 2022/1/14
 */
@Component
public class HeaderTokenGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return new HeaderTokenGatewayFilter();
    }
}
