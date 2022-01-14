package com.asan.ecommerce.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>网关需要注入到容器中的 Bean</h1>
 * @author mingkai yun
 * @date 2022/1/14
 */
@Configuration
public class GatewayBeanConf {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
