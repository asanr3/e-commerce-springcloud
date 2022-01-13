package com.asan.ecommerce.util;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.constant.CommonConstant;
import com.asan.ecommerce.vo.LoginUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;

/**
 * <h1>JWT Token 解析工具类</h1>
 *
 * @author mingkai yun
 * @date 2022/1/13
 */
public class TokenParseUtil {
    /**
     * <h2>从 JWT Token 中解析 LoginUserInfo 对象</h2>
     */
    public static LoginUserInfo parseUserInfoFromToken(String token) throws Exception {

        if (null == token) {
            return null;
        }

        // claims 存储的就是jwt payload --> KV，K：CommonConstant.JWT_USER_INFO_KEY, V：JSON.toJSONString(loginUserInfo)
        Jws<Claims> claimsJws = parseToken(token, getPublicKey());
        Claims body = claimsJws.getBody();

        // 如果 Token 已经过期了, 返回 null
        if (body.getExpiration().before(Calendar.getInstance().getTime())) {
            return null;
        }

        // 返回 Token 中保存的用户信息
        return JSON.parseObject(
                body.get(CommonConstant.JWT_USER_INFO_KEY).toString(),
                LoginUserInfo.class
        );
    }

    /**
     * <h2>通过公钥去解析 JWT Token</h2>
     */
    private static Jws<Claims> parseToken(String token, PublicKey publicKey) {

        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }

    /**
     * <h2>根据本地存储的公钥获取到 PublicKey 对象</h2>
     */
    private static PublicKey getPublicKey() throws Exception {

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(
                new BASE64Decoder().decodeBuffer(CommonConstant.PUBLIC_KEY)
        );
        return KeyFactory.getInstance("RSA").generatePublic(keySpec);
    }
}
