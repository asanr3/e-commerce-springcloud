package com.asan.ecommerce.controller;

import com.asan.ecommerce.service.SleuthTraceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>打印跟踪信息</h1>
 * @author mingkai yun
 * @date 2022/1/16
 */
@Slf4j
@RestController
@RequestMapping("/sleuth")
public class SleuthTraceInfoController {
    private final SleuthTraceInfoService traceInfoService;

    public SleuthTraceInfoController(SleuthTraceInfoService traceInfoService) {
        this.traceInfoService = traceInfoService;
    }

    /**
     * <h2>打印日志跟踪信息</h2>
     * */
    @GetMapping("/trace-info")
    public void logCurrentTraceInfo() {
        traceInfoService.logCurrentTraceInfo();
    }
}
