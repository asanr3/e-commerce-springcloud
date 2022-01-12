package com.asan.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>授权中心鉴权之后给客户端的 Token</h1>
 *
 * @author mingkai yun
 * @date 2022/1/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken {
    /**
     * JWT
     */
    private String token;
}
