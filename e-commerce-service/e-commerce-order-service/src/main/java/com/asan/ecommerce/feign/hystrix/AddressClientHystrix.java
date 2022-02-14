package com.asan.ecommerce.feign.hystrix;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.account.AddressInfo;
import com.asan.ecommerce.common.TableId;
import com.asan.ecommerce.feign.AddressClient;
import com.asan.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * <h1>账户服务熔断降级兜底策略</h1>
 *
 * @author mingkai yun
 * @date 2022/2/14
 */
@Slf4j
@Component
public class AddressClientHystrix implements AddressClient {

    @Override
    public CommonResponse<AddressInfo> getAddressInfoByTablesId(TableId tableId) {

        log.error("[account client feign request error in order service] get address info" +
                "error: [{}]", JSON.toJSONString(tableId));
        return new CommonResponse<>(
                -1,
                "[account client feign request error in order service]",
                new AddressInfo(-1L, Collections.emptyList())
        );
    }
}
