package com.asan.ecommerce;

import com.asan.ecommerce.conf.DataSourceProxyAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * <h1>商品微服务启动入口</h1>
 * 启动依赖组件/中间件: Redis + MySQL + Nacos + Kafka + Zipkin
 * swagger地址：http://127.0.0.1:8001/ecommerce-goods-service/doc.html#
 *
 * @author mingkai yun
 * @date 2022/1/20
 */
@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
@Import(DataSourceProxyAutoConfiguration.class)
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
