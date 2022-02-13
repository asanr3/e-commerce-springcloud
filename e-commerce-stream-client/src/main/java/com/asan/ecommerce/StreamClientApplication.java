package com.asan.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <h1>基于 SpringCloud Stream 构建消息驱动微服务</h1>
 *
 * @author mingkai yun
 * @date 2022/2/12
 */
@EnableDiscoveryClient
@SpringBootApplication
public class StreamClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(StreamClientApplication.class, args);
    }
}
