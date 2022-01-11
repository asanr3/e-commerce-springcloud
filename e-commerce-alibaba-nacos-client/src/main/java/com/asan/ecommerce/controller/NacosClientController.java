package com.asan.ecommerce.controller;

import com.asan.ecommerce.service.NacosClientService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1>nacos client controller</h1>
 *
 * @author mingkai yun
 * @date 2022/1/9
 */
@Api(value = "NacosClientController", tags = "Nacos客户端接口")
@Slf4j
@RestController
@RequestMapping("/nacos-client")
public class NacosClientController {

    private final NacosClientService nacosClientService;

    public NacosClientController(NacosClientService nacosClientService) {
        this.nacosClientService = nacosClientService;
    }

    @ApiOperation(value = "根据 service id 获取服务所有的实例信息", notes = "根据 service id 获取服务所有的实例信息")
    @ApiImplicitParams({})
    @GetMapping("/service-instance")
    public List<ServiceInstance> logNacosClientInfo(
            @RequestParam(defaultValue = "e-commerce-nacos-client") String serviceId) {

        log.info("coming in log nacos client info: [{}]", serviceId);
        return nacosClientService.getNacosClientInfo(serviceId);
    }
}
