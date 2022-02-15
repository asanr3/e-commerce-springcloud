package com.asan.ecommerce.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * <h1>自定义物流消息通信信道(Source)</h1>
 *
 * @author mingkai yun
 * @date 2022/2/15
 */
public interface LogisticsSource {

    /**
     * 输出信道名称
     */
    String OUTPUT = "logisticsOutput";

    /**
     * <h2>物流 Source -> logisticsOutput</h2>
     * 通信信道的名称是 logisticsOutput, 对应到 yml 文件里的配置
     */
    @Output(LogisticsSource.OUTPUT)
    MessageChannel logisticsOutput();
}
