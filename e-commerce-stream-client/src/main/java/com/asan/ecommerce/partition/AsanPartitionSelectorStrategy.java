package com.asan.ecommerce.partition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.binder.PartitionSelectorStrategy;
import org.springframework.stereotype.Component;

/**
 * <h1>决定 message 发送到哪个分区的策略</h1>
 *
 * @author mingkai yun
 * @date 2022/2/12
 */
@Slf4j
@Component
public class AsanPartitionSelectorStrategy implements PartitionSelectorStrategy {

    /**
     * <h2>选择分区的策略</h2>
     */
    @Override
    public int selectPartition(Object key, int partitionCount) {

        int partition = key.toString().hashCode() % partitionCount;
        log.info("SpringCloud Stream Asan Selector info: [{}], [{}], [{}]",
                key.toString(), partitionCount, partition);

        return partition;
    }
}
