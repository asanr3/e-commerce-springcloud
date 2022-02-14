package com.asan.ecommerce.feign;

import com.asan.ecommerce.account.BalanceInfo;
import com.asan.ecommerce.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <h1>用户账户服务 Feign 接口</h1>
 * 不安全的Feign 接口（没有兜底策略的），因为我们有全局事务，这种直接让他抛出异常，让全局事务进行回滚
 *
 * @author mingkai yun
 * @date 2022/2/14
 */
@FeignClient(
        contextId = "NotSecuredBalanceClient",
        value = "e-commerce-account-service"
)
public interface NotSecuredBalanceClient {

    /**
     * 根据用户id扣减账户余额
     *
     * @param balanceInfo 用户账户余额信息
     * @return {@link BalanceInfo}
     */
    @RequestMapping(
            value = "/ecommerce-account-service/balance/deduct-balance",
            method = RequestMethod.PUT
    )
    CommonResponse<BalanceInfo> deductBalance(@RequestBody BalanceInfo balanceInfo);
}
