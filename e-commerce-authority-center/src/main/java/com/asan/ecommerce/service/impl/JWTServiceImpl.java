package com.asan.ecommerce.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.constant.AuthorityConstant;
import com.asan.ecommerce.constant.CommonConstant;
import com.asan.ecommerce.dao.EcommerceUserDao;
import com.asan.ecommerce.entity.EcommerceUser;
import com.asan.ecommerce.service.IJWTService;
import com.asan.ecommerce.vo.LoginUserInfo;
import com.asan.ecommerce.vo.UsernameAndPassword;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * <h1>JWT 相关服务接口实现</h1>
 *
 * @author mingkai yun
 * @date 2022/1/12
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class JWTServiceImpl implements IJWTService {

    private final EcommerceUserDao ecommerceUserDao;

    public JWTServiceImpl(EcommerceUserDao ecommerceUserDao) {
        this.ecommerceUserDao = ecommerceUserDao;
    }

    /**
     * <h2>生成 JWT Token, 使用默认的超时时间</h2>
     *
     * @param username 用户名
     * @param password 密码
     * @return JWT Token
     * @throws Exception
     */
    @Override
    public String generateToken(String username, String password) throws Exception {
        return generateToken(username, password, 0);
    }

    /**
     * <h2>生成指定超时时间的 Token, 单位是天</h2>
     *
     * @param username 用户名
     * @param password 密码
     * @param expire   超时时间(单位是天)
     * @return Token
     * @throws Exception
     */
    @Override
    public String generateToken(String username, String password, int expire) throws Exception {
        // 首先需要验证用户是否能够通过授权校验, 即输入的用户名和密码能否匹配数据表记录
        EcommerceUser ecommerceUser = ecommerceUserDao.findByUsernameAndPassword(
                username, password
        );
        if (null == ecommerceUser) {
            log.error("can not find user: [{}], [{}]", username, password);
            return null;
        }

        // Token 中塞入对象, 即 JWT 中存储的信息, 后端拿到这些信息就可以知道是哪个用户在操作
        LoginUserInfo loginUserInfo = new LoginUserInfo(
                ecommerceUser.getId(), ecommerceUser.getUsername()
        );

        if (expire <= 0) {
            expire = AuthorityConstant.DEFAULT_EXPIRE_DAY;
        }

        // 计算超时时间
        ZonedDateTime zdt = LocalDate.now().plus(expire, ChronoUnit.DAYS)
                .atStartOfDay(ZoneId.systemDefault());
        Date expireDate = Date.from(zdt.toInstant());

        return Jwts.builder()
                // jwt payload --> KV
                .claim(CommonConstant.JWT_USER_INFO_KEY, JSON.toJSONString(loginUserInfo))
                // jwt id
                .setId(UUID.randomUUID().toString())
                // jwt 过期时间
                .setExpiration(expireDate)
                // jwt 签名 --> 加密
                .signWith(getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    /**
     * <h2>注册用户并生成 Token 返回</h2>
     *
     * @param usernameAndPassword 用户名和密码对象
     * @return Token
     * @throws Exception
     */
    @Override
    public String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword) throws Exception {
        // 先去校验用户名是否存在, 如果存在, 不能重复注册
        EcommerceUser oldUser = ecommerceUserDao.findByUsername(
                usernameAndPassword.getUsername());
        if (null != oldUser) {
            log.error("username is registered: [{}]", oldUser.getUsername());
            return null;
        }

        EcommerceUser ecommerceUser = new EcommerceUser();
        ecommerceUser.setUsername(usernameAndPassword.getUsername());
        String pwd = usernameAndPassword.getPassword();
        // 保存到数据库的密码需要是MD5编码以后的密码，这里简单判断一下传入的密码是否是MD5的
        if (usernameAndPassword.getPassword().length() < 32) {
            // 将密码编码为MD5格式
            pwd = MD5.create().digestHex(usernameAndPassword.getPassword());
        }
        ecommerceUser.setPassword(pwd);
        ecommerceUser.setExtraInfo("{}");

        // 注册一个新用户, 写一条记录到数据表中
        ecommerceUser = ecommerceUserDao.save(ecommerceUser);
        log.info("register user success: [{}], [{}]", ecommerceUser.getUsername(),
                ecommerceUser.getId());

        // 生成 token 并返回
        return generateToken(ecommerceUser.getUsername(), ecommerceUser.getPassword());
    }

    /**
     * <h2>根据本地存储的私钥获取到 PrivateKey 对象</h2>
     */
    private PrivateKey getPrivateKey() throws Exception {

        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                new BASE64Decoder().decodeBuffer(AuthorityConstant.PRIVATE_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(priPKCS8);
    }
}
