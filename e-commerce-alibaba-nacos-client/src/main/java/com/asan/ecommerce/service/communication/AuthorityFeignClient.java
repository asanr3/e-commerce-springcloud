package com.asan.ecommerce.service.communication;

import com.asan.ecommerce.service.communication.hystrix.AuthorityFeignClientFallback;
import com.asan.ecommerce.vo.JwtToken;
import com.asan.ecommerce.vo.UsernameAndPassword;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <h1>与 Authority 服务通信的 Feign Client 接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/1/23
 */
@FeignClient(
        contextId = "AuthorityFeignClient", value = "e-commerce-authority-center",
       fallback = AuthorityFeignClientFallback.class
//         fallbackFactory = AuthorityFeignClientFallbackFactory.class
)
public interface AuthorityFeignClient {

    /**
     * <h2>通过 OpenFeign 访问 Authority 获取 Token</h2>
     */
    @RequestMapping(value = "/ecommerce-authority-center/authority/token",
            method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    JwtToken getTokenByFeign(@RequestBody UsernameAndPassword usernameAndPassword);
}
