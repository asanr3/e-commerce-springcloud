package com.asan.ecommerce.service;

import com.asan.ecommerce.account.BalanceInfo;

/**
 * <h2>用于余额相关的服务接口定义</h2>
 *
 * @author mingkai yun
 * @date 2022/1/18
 */
public interface IBalanceService {
    /**
     * <h2>获取当前用户余额信息，这里不设计入参userid，是因为防止数据包被修改，导致查询到别的用户的余额，从请求中可以直接拿到userid</h2>
     *
     * @return {@link BalanceInfo}
     */
    BalanceInfo getCurrentUserBalanceInfo();

    /**
     * <h2>扣减用户余额</h2>
     *
     * @param balanceInfo 代表想要扣减的余额
     * @return {@link BalanceInfo}
     */
    BalanceInfo deductBalance(BalanceInfo balanceInfo);
}
