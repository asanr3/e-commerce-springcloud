package com.asan.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <h1>Nacos Client 工程启动入口</h1>
 *
 * @author mingkai yun
 * @date 2022/1/9
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosClientApplication {
    public static void main(String[] args) {

        SpringApplication.run(NacosClientApplication.class, args);
    }
}
