package com.asan.ecommerce.stream;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.vo.AsanMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * <h1>使用默认的信道实现消息的接收</h1>
 * Sink用于有单个输入（inbound）通道的应用。
 *
 * @author mingkai yun
 * @date 2022/2/12
 */
@Slf4j
@EnableBinding(Sink.class)
public class DefaultReceiveService {

    /**
     * <h2>使用默认的输入信道接收消息</h2>
     * Sink用于有单个输入（inbound）通道的应用。
     */
    @StreamListener(Sink.INPUT)
    public void receiveMessage(Object payload) {

        log.info("in DefaultReceiveService consume message start");
        AsanMessage asanMessage = JSON.parseObject(
                payload.toString(), AsanMessage.class
        );
        // 消费消息
        log.info("in DefaultReceiveService consume message success: [{}]",
                JSON.toJSONString(asanMessage));
    }
}
