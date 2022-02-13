package com.asan.ecommerce.stream.asan;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * <h1>自定义输出信道</h1>
 * @author mingkai yun
 * @date 2022/2/12
 * */
public interface AsanSource {

    String OUTPUT = "asanOutput";

    /** 输出信道的名称是 asanOutput, 需要使用 Stream 绑定器在 yml 文件中声明 */
    @Output(AsanSource.OUTPUT)
    MessageChannel asanOutput();
}
