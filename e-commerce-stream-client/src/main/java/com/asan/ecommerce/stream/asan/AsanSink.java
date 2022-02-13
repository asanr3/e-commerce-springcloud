package com.asan.ecommerce.stream.asan;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * <h1>自定义输入信道</h1>
 *
 * @author mingkai yun
 * @date 2022/2/12
 */
public interface AsanSink {

    String INPUT = "asanInput";

    /**
     * 输入信道的名称是 qinyiInput, 需要使用 Stream 绑定器在 yml 文件中配置
     */
    @Input(AsanSink.INPUT)
    SubscribableChannel asanInput();
}
