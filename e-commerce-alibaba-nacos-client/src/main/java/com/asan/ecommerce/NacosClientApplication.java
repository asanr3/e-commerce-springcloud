package com.asan.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <h1>Nacos Client 工程启动入口</h1>
 * 注解：@RefreshScope 刷新配置
 * 注解：@EnableCircuitBreaker 开启hystrix
 *
 * @author mingkai yun
 * @date 2022/1/9
 */
@ServletComponentScan
@EnableCircuitBreaker
@EnableFeignClients
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class NacosClientApplication {
    public static void main(String[] args) {

        SpringApplication.run(NacosClientApplication.class, args);
    }
}
