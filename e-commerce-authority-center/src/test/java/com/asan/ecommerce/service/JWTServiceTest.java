package com.asan.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.util.TokenParseUtil;
import com.asan.ecommerce.vo.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>JWT 相关服务测试类</h1>
 *
 * @author mingkai yun
 * @date 2022/1/13
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class JWTServiceTest {
    @Autowired
    private IJWTService ijwtService;

    @Test
    public void testGenerateAndParseToken() throws Exception {

        // 根据账号密码生成token
        String jwtToken = ijwtService.generateToken(
                "asan123@qq.com",
                "25d55ad283aa400af464c76d713c07ad"
        );
        log.info("jwt token is: [{}]", jwtToken);

        // 解析token
        LoginUserInfo userInfo = TokenParseUtil.parseUserInfoFromToken(jwtToken);
        log.info("parse token: [{}]", JSON.toJSONString(userInfo));
    }
}
