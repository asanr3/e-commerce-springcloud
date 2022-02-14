package com.asan.ecommerce.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>创建订单时发送的物流消息</h1>
 *
 * @author mingkai yun
 * @date 2022/2/14
 */
@ApiModel(description = "Stream 物流消息对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogisticsMessage {

    @ApiModelProperty(value = "用户表主键 id")
    private Long userId;

    @ApiModelProperty(value = "订单表主键 id")
    private Long orderId;

    @ApiModelProperty(value = "用户地址表主键 id")
    private Long addressId;

    @ApiModelProperty(value = "备注信息(json 存储)")
    private String extraInfo;
}
