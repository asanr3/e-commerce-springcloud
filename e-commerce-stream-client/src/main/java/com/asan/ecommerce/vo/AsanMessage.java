package com.asan.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>消息传递对象: SpringCloud Stream + Kafka/RocketMQ</h1>
 *
 * @author mingkai yun
 * @date 2022/2/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsanMessage {

    private Integer id;
    private String projectName;
    private String org;
    private String author;
    private String version;

    /**
     * <h2>返回一个默认的消息, 方便使用</h2>
     */
    public static AsanMessage defaultMessage() {

        return new AsanMessage(
                1,
                "e-commerce-stream-client",
                "asan.com",
                "Asan",
                "1.0"
        );
    }
}
