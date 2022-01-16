package com.asan.ecommerce.service;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <h1>使用代码更直观的看到 Sleuth 生成的相关跟踪信息</h1>
 *
 * @author mingkai yun
 * @date 2022/1/16
 */
@Slf4j
@Service
public class SleuthTraceInfoService {
    /**
     * brave.Tracer 跟踪对象
     */
    private final Tracer tracer;

    public SleuthTraceInfoService(Tracer tracer) {
        this.tracer = tracer;
    }

    /**
     * <h2>打印当前的跟踪信息到日志中</h2>
     */
    public void logCurrentTraceInfo() {

        log.info("Sleuth trace id: [{}]", tracer.currentSpan().context().traceId());
        log.info("Sleuth span id: [{}]", tracer.currentSpan().context().spanId());
    }
}
