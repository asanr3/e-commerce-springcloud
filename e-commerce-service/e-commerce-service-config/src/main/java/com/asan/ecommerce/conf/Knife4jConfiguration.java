package com.asan.ecommerce.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Knife4j接口文档配置类
 *
 * @author mingkai yun
 * @date 2022/1/19
 */
@EnableSwagger2
@Configuration
public class Knife4jConfiguration {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("e-commerce-service restful apis")
                        .description("e-commerce-service")
                        .version("1.0")
                        .contact(new Contact("Asan", "", ""))
                        .build())
                //分组名称
                .groupName("3.X版本")
                .select()
                //这里指定扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.asan.ecommerce"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
