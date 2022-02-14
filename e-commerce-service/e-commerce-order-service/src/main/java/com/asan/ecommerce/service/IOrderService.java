package com.asan.ecommerce.service;

import com.asan.ecommerce.common.TableId;
import com.asan.ecommerce.order.OrderInfo;
import com.asan.ecommerce.vo.PageSimpleOrderDetail;

/**
 * <h1>订单相关服务接口定义</h1>
 *
 * @author mingkai yun
 * @date 2022/2/14
 */
public interface IOrderService {

    /**
     * <h2>下单(分布式事务): 创建订单 -> 扣减库存 -> 扣减余额 -> 创建物流信息(Stream + Kafka)</h2>
     *
     * @param orderInfo 用户发起购买订单对象
     * @return 订单表ID
     */
    TableId createOrder(OrderInfo orderInfo);

    /**
     * <h2>获取当前用户的订单信息: 带有分页</h2>
     *
     * @param page 分页参数
     * @return 分页订单详情对象
     */
    PageSimpleOrderDetail getSimpleOrderDetailByPage(int page);
}
