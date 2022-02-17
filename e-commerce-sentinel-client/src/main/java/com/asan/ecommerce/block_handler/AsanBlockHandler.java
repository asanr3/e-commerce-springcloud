package com.asan.ecommerce.block_handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.asan.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * <h1>自定义通用的限流处理逻辑</h1>
 *
 * @author mingkai yun
 * @date 2022/2/17
 */
@Slf4j
public class AsanBlockHandler {

    /**
     * <h2>通用限流处理方法</h2>
     * 这个方法必须是 static 的
     */
    public static CommonResponse<String> asanHandleBlockException(BlockException exception) {

        log.error("trigger asan block handler: [{}], [{}]",
                JSON.toJSONString(exception.getRule()), exception.getRuleLimitApp());
        return new CommonResponse<>(
                -1,
                "flow rule trigger block exception",
                null
        );
    }
}
