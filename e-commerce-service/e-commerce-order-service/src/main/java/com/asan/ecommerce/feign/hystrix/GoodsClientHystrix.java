package com.asan.ecommerce.feign.hystrix;

import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.common.TableId;
import com.asan.ecommerce.feign.SecuredGoodsClient;
import com.asan.ecommerce.goods.SimpleGoodsInfo;
import com.asan.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * <h1>商品服务熔断降级兜底</h1>
 *
 * @author mingkai yun
 * @date 2022/2/14
 */
@Slf4j
@Component
public class GoodsClientHystrix implements SecuredGoodsClient {

    @Override
    public CommonResponse<List<SimpleGoodsInfo>> getSimpleGoodsInfoByTableId(
            TableId tableId) {

        log.error("[goods client feign request error in order service] get simple goods" +
                "error: [{}]", JSON.toJSONString(tableId));
        return new CommonResponse<>(
                -1,
                "[goods client feign request error in order service]",
                Collections.emptyList()
        );
    }
}
