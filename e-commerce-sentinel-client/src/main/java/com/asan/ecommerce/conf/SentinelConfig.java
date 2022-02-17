package com.asan.ecommerce.conf;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>开启服务间的调用保护, 需要给 RestTemplate 做一些包装</h1>
 *
 * @author mingkai yun
 * @date 2022/2/17
 */
@Slf4j
@Configuration
public class SentinelConfig {

    /**
     * <h2>包装 RestTemplate</h2>
     */
    @Bean
   @SentinelRestTemplate(
           fallback = "handleFallback", fallbackClass = RestTemplateExceptionUtil.class,
           blockHandler = "handleBlock", blockHandlerClass = RestTemplateExceptionUtil.class
   )
    public RestTemplate restTemplate() {
        // 可以对其做一些业务相关的配置
        return new RestTemplate();
    }
}
