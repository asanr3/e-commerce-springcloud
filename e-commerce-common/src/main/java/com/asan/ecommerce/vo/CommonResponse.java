package com.asan.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <h1>通用响应对象定义</h1>
 * {
 * "code": 0,
 * "message": "",
 * "data": {}
 * }
 *
 * @author mingkai yun
 * @date 2022/1/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 泛型响应数据
     */
    private T data;

    public CommonResponse(Integer code, String message) {

        this.code = code;
        this.message = message;
    }

}
