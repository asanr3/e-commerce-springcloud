package com.asan.ecommerce.service;

import com.asan.ecommerce.vo.UsernameAndPassword;

/**
 * <h1>JWT 相关服务接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/1/12
 */
public interface IJWTService {
    /**
     * <h2>生成 JWT Token, 使用默认的超时时间</h2>
     *
     * @param username 用户名
     * @param password 密码
     * @return JWT Token
     * @throws Exception
     */
    String generateToken(String username, String password) throws Exception;

    /**
     * <h2>生成指定超时时间的 Token, 单位是天</h2>
     *
     * @param username 用户名
     * @param password 密码
     * @param expire   超时时间(单位是天)
     * @return Token
     * @throws Exception
     */
    String generateToken(String username, String password, int expire) throws Exception;

    /**
     * <h2>注册用户并生成 Token 返回</h2>
     *
     * @param usernameAndPassword 用户名和密码对象
     * @return Token
     * @throws Exception
     */
    String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword)
            throws Exception;
}
