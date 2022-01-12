package com.asan.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>用户名和密码</h1>
 *
 * @author mingkai yun
 * @date 2022/1/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsernameAndPassword {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
