package com.asan.ecommerce.service.communication.hystrix;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.service.communication.AuthorityFeignClient;
import com.asan.ecommerce.vo.JwtToken;
import com.asan.ecommerce.vo.UsernameAndPassword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <h1>AuthorityFeignClient 后备 fallback</h1>
 *
 * @author mingkai yun
 * @date 2022/1/25
 */
@Slf4j
@Component
public class AuthorityFeignClientFallback implements AuthorityFeignClient {

    @Override
    public JwtToken getTokenByFeign(UsernameAndPassword usernameAndPassword) {

        log.info("authority feign client get token by feign request error " +
                "(Hystrix Fallback): [{}]", JSON.toJSONString(usernameAndPassword));
        return new JwtToken("asan");
    }
}
