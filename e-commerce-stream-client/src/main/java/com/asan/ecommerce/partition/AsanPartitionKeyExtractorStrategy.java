package com.asan.ecommerce.partition;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.vo.AsanMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * <h1>自定义从 Message 中提取 partition key 的策略</h1>
 *
 * @author mingkai yun
 * @date 2022/2/12
 */
@Slf4j
@Component
public class AsanPartitionKeyExtractorStrategy implements PartitionKeyExtractorStrategy {

    @Override
    public Object extractKey(Message<?> message) {

        AsanMessage asanMessage = JSON.parseObject(
                message.getPayload().toString(), AsanMessage.class
        );
        // 自定义提取 key
        String key = asanMessage.getProjectName();
        log.info("SpringCloud Stream Asan Partition Key: [{}]", key);
        return key;
    }
}
