package com.asan.ecommerce.service.async;

import com.asan.ecommerce.goods.GoodsInfo;

import java.util.List;

/**
 * <h1>异步服务接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/1/20
 */
public interface IAsyncService {

    /**
     * <h2>异步将商品信息保存下来</h2>
     *
     * @param goodsInfos 详细的商品信息
     * @param taskId     异步任务ID
     */
    void asyncImportGoods(List<GoodsInfo> goodsInfos, String taskId);
}
