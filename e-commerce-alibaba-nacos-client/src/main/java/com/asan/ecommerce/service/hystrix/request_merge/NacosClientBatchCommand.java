package com.asan.ecommerce.service.hystrix.request_merge;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.service.NacosClientService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;

import java.util.Collections;
import java.util.List;

/**
 * <h1>批量请求 Hystrix Command</h1>
 *
 * @author mingkai yun
 * @date 2022/1/25
 */
@Slf4j
public class NacosClientBatchCommand extends HystrixCommand<List<List<ServiceInstance>>> {

    private final NacosClientService nacosClientService;
    private final List<String> serviceIds;

    protected NacosClientBatchCommand(
            NacosClientService nacosClientService, List<String> serviceIds
    ) {

        super(
                Setter.withGroupKey(
                        HystrixCommandGroupKey.Factory.asKey("NacosClientBatchCommand")
                )
        );

        this.nacosClientService = nacosClientService;
        this.serviceIds = serviceIds;
    }

    @Override
    protected List<List<ServiceInstance>> run() throws Exception {

        log.info("use nacos client batch command to get result: [{}]",
                JSON.toJSONString(serviceIds));
        return nacosClientService.getNacosClientInfos(serviceIds);
    }

    @Override
    protected List<List<ServiceInstance>> getFallback() {

        log.warn("nacos client batch command failure, use fallback");
        return Collections.emptyList();
    }
}
