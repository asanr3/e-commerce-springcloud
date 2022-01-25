package com.asan.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author mingkai yun
 * @date 2022/1/9
 */
@Slf4j
@Service
public class NacosClientService {

    private final DiscoveryClient discoveryClient;

    public NacosClientService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    /**
     * <h2>打印 Nacos Client 信息到日志中</h2>
     */
    public List<ServiceInstance> getNacosClientInfo(String serviceId) {
        // 测试 UseHystrixCommandAnnotation 的超时
       // try {
       //     Thread.sleep(2000);
       // } catch (InterruptedException ex) {
       //     //
       // }

        // 测试 NacosClientHystrixCommand 熔断
       throw new RuntimeException("has some error");
       //  log.info("request nacos client to get service instance info: [{}]", serviceId);
       //  return discoveryClient.getInstances(serviceId);
    }
    /**
     * <h2>提供给编程方式的 Hystrix 请求合并</h2>
     * */
    public List<List<ServiceInstance>> getNacosClientInfos(List<String> serviceIds) {

        log.info("request nacos client to get service instance infos: [{}]",
                JSON.toJSONString(serviceIds));
        List<List<ServiceInstance>> result = new ArrayList<>(serviceIds.size());

        serviceIds.forEach(s -> result.add(discoveryClient.getInstances(s)));
        return result;
    }

    // 使用注解实现 Hystrix 请求合并

    @HystrixCollapser(
            batchMethod = "findNacosClientInfos",
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            collapserProperties = {
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "300")
            }
    )
    public Future<List<ServiceInstance>> findNacosClientInfo(String serviceId) {

        // 系统运行正常, 不会走这个方法
        throw new RuntimeException("This method body should not be executed!");
    }

    @HystrixCommand
    public List<List<ServiceInstance>> findNacosClientInfos(List<String> serviceIds) {

        log.info("coming in find nacos client infos: [{}]", JSON.toJSONString(serviceIds));
        return getNacosClientInfos(serviceIds);
    }
}
