package com.asan.ecommerce.controller;

import com.asan.ecommerce.service.communication.AuthorityFeignClient;
import com.asan.ecommerce.service.communication.UseFeignApi;
import com.asan.ecommerce.service.communication.UseRestTemplateService;
import com.asan.ecommerce.service.communication.UseRibbonService;
import com.asan.ecommerce.vo.JwtToken;
import com.asan.ecommerce.vo.UsernameAndPassword;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>微服务通信 Controller</h1>
 *
 * @author mingkai yun
 * @date 2022/1/23
 */
@RestController
@RequestMapping("/communication")
public class CommunicationController {

    private final UseRestTemplateService restTemplateService;
    private final UseRibbonService ribbonService;
    private final AuthorityFeignClient feignClient;
    private final UseFeignApi useFeignApi;

    public CommunicationController(UseRestTemplateService restTemplateService,
                                   UseRibbonService ribbonService,
                                   AuthorityFeignClient feignClient,
                                   UseFeignApi useFeignApi) {
        this.restTemplateService = restTemplateService;
        this.ribbonService = ribbonService;
        this.feignClient = feignClient;
        this.useFeignApi = useFeignApi;
    }

    @PostMapping("/rest-template")
    public JwtToken getTokenFromAuthorityService(
            @RequestBody UsernameAndPassword usernameAndPassword) {
        return restTemplateService.getTokenFromAuthorityService(usernameAndPassword);
    }

    @PostMapping("/rest-template-load-balancer")
    public JwtToken getTokenFromAuthorityServiceWithLoadBalancer(
            @RequestBody UsernameAndPassword usernameAndPassword) {
        return restTemplateService.getTokenFromAuthorityServiceWithLoadBalancer(
                usernameAndPassword);
    }

    @PostMapping("/ribbon")
    public JwtToken getTokenFromAuthorityServiceByRibbon(
            @RequestBody UsernameAndPassword usernameAndPassword) {
        return ribbonService.getTokenFromAuthorityServiceByRibbon(usernameAndPassword);
    }

    @PostMapping("/thinking-in-ribbon")
    public JwtToken thinkingInRibbon(@RequestBody UsernameAndPassword usernameAndPassword) {
        return ribbonService.thinkingInRibbon(usernameAndPassword);
    }

    @PostMapping("/token-by-feign")
    public JwtToken getTokenByFeign(@RequestBody UsernameAndPassword usernameAndPassword) {
        return feignClient.getTokenByFeign(usernameAndPassword);
    }

    @PostMapping("/thinking-in-feign")
    public JwtToken thinkingInFeign(@RequestBody UsernameAndPassword usernameAndPassword) {
        return useFeignApi.thinkingInFeign(usernameAndPassword);
    }
}
