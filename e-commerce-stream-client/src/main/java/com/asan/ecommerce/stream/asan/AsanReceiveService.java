package com.asan.ecommerce.stream.asan;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.vo.AsanMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * <h1>使用自定义的输入信道实现消息的接收</h1>
 * 将@EnableBinding注解添加到应用的配置类，就可以把一个spring应用转换成Spring Cloud Stream应用，@EnableBinding注解本身就包含@Configuration注解，会触发Spring Cloud Stream 基本配置。
 * Sink用于有单个输入（inbound）通道的应用。
 *
 * @author mingkai yun
 * @date 2022/2/12
 */
@Slf4j
@EnableBinding(AsanSink.class)
public class AsanReceiveService {

    /**
     * 使用自定义的输入信道接收消息
     * 注解@StreamListener 定义在方法中，被修饰的方法注册为消息中间件上数据流的事件监听器，注解中属性值对应了监听的消息通道名。
     * Sink用于有单个输入（inbound）通道的应用。
     */
    @StreamListener(AsanSink.INPUT)
    public void receiveMessage(@Payload Object payload) {

        log.info("in AsanReceiveService consume message start");
        AsanMessage qinyiMessage = JSON.parseObject(payload.toString(), AsanMessage.class);
        log.info("in AsanReceiveService consume message success: [{}]",
                JSON.toJSONString(qinyiMessage));
    }
}
