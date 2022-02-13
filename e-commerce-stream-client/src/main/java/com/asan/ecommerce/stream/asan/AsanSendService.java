package com.asan.ecommerce.stream.asan;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.vo.AsanMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * <h1>使用自定义的通信信道 AsanSource 实现消息的发送</h1>
 * 将@EnableBinding注解添加到应用的配置类，就可以把一个spring应用转换成Spring Cloud Stream应用，@EnableBinding注解本身就包含@Configuration注解，会触发Spring Cloud Stream 基本配置。
 * Source用于有单个输出（outbound）通道的应用。
 * @author mingkai yun
 * @date 2022/2/12
 */
@Slf4j
@EnableBinding(AsanSource.class)
public class AsanSendService {

    private final AsanSource asanSource;

    public AsanSendService(AsanSource asanSource) {
        this.asanSource = asanSource;
    }

    /**
     * <h2>使用自定义的输出信道发送消息</h2>
     */
    public void sendMessage(AsanMessage message) {

        String _message = JSON.toJSONString(message);
        log.info("in AsanSendService send message: [{}]", _message);
        asanSource.asanOutput().send(
                MessageBuilder.withPayload(_message).build()
        );
    }
}
