package com.asan.ecommerce.feign;

import com.asan.ecommerce.common.TableId;
import com.asan.ecommerce.goods.DeductGoodsInventory;
import com.asan.ecommerce.goods.SimpleGoodsInfo;
import com.asan.ecommerce.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <h1>不安全的商品服务 Feign 接口</h1>
 * 不安全的Feign 接口（没有兜底策略的），因为我们有全局事务，这种直接让他抛出异常，让全局事务进行回滚
 *
 * @author mingkai yun
 * @date 2022/2/14
 */
@FeignClient(
        contextId = "NotSecuredGoodsClient",
        value = "e-commerce-goods-service"
)
public interface NotSecuredGoodsClient {

    /**
     * <h2>根据 商品id 扣减商品库存</h2>
     *
     * @param deductGoodsInventories 扣减商品库存对象
     * @return Boolean
     */
    @RequestMapping(
            value = "/ecommerce-goods-service/goods/deduct-goods-inventory",
            method = RequestMethod.PUT
    )
    CommonResponse<Boolean> deductGoodsInventory(
            @RequestBody List<DeductGoodsInventory> deductGoodsInventories);

    /**
     * <h2>根据 ids 查询简单的商品信息</h2>
     *
     * @param tableId 商品id
     * @return 简单的商品信息
     */
    @RequestMapping(
            value = "/ecommerce-goods-service/goods/simple-goods-info",
            method = RequestMethod.POST
    )
    CommonResponse<List<SimpleGoodsInfo>> getSimpleGoodsInfoByTableId(
            @RequestBody TableId tableId);
}
