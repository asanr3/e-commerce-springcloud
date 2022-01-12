package com.asan.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>登录用户信息</h1>
 * id和username是主键和唯一键，设计id和username两个字段是因为可能涉及到两种场景：1:只想知道是哪位用户，2：想获取用户更详细的信息
 * 如果只设计id，那么每次都要查表，针对第一种情况不是很友好
 *
 * @author mingkai yun
 * @date 2022/1/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfo {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;
}
