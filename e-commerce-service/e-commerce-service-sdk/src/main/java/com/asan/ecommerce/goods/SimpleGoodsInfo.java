package com.asan.ecommerce.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>简单的商品信息: 封面</h1>
 *
 * @author mingkai yun
 * @date 2022/1/20
 */
@ApiModel(description = "简单的商品信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleGoodsInfo {

    @ApiModelProperty(value = "商品表主键 id")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品图片")
    private String goodsPic;

    @ApiModelProperty(value = "商品价格, 单位: 分")
    private Integer price;

    public SimpleGoodsInfo(Long id) {
        this.id = id;
    }
}
