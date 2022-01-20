package com.asan.ecommerce.service;


import com.asan.ecommerce.common.TableId;
import com.asan.ecommerce.goods.DeductGoodsInventory;
import com.asan.ecommerce.goods.GoodsInfo;
import com.asan.ecommerce.goods.SimpleGoodsInfo;
import com.asan.ecommerce.vo.PageSimpleGoodsInfo;

import java.util.List;

/**
 * <h1>商品微服务相关服务接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/1/20
 */
public interface IGoodsService {

    /**
     * <h2>根据 TableId 查询商品详细信息</h2>
     *
     * @param tableId 商品表主键 id
     * @return {@link GoodsInfo}S
     */
    List<GoodsInfo> getGoodsInfoByTableId(TableId tableId);

    /**
     * <h2>获取分页的商品信息</h2>
     *
     * @param page 页数
     * @return {@link PageSimpleGoodsInfo}
     */
    PageSimpleGoodsInfo getSimpleGoodsInfoByPage(int page);

    /**
     * <h2>根据 TableId 查询简单商品信息</h2>
     *
     * @param tableId 商品表主键 id
     * @return {@link SimpleGoodsInfo}S
     */
    List<SimpleGoodsInfo> getSimpleGoodsInfoByTableId(TableId tableId);

    /**
     * <h2>扣减商品库存</h2>
     *
     * @param deductGoodsInventories 扣减商品库存对象
     * @return Boolean
     */
    Boolean deductGoodsInventory(List<DeductGoodsInventory> deductGoodsInventories);
}
