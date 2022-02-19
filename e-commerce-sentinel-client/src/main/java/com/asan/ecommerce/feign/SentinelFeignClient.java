package com.asan.ecommerce.feign;

import com.asan.ecommerce.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <h1>通过 Sentinel 对 OpenFeign 实现熔断降级</h1>
 *
 * @author mingkai yun
 * @date 2022/2/19
 */
@FeignClient(
        value = "e-commerce-asan",
        fallback = SentinelFeignClientFallback.class
)
public interface SentinelFeignClient {

    @RequestMapping(value = "asan", method = RequestMethod.GET)
    CommonResponse<String> getResultByFeign(@RequestParam Integer code);
}
