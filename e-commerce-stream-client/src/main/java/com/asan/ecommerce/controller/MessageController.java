package com.asan.ecommerce.controller;

import com.asan.ecommerce.stream.DefaultSendService;

import com.asan.ecommerce.stream.asan.AsanSendService;
import com.asan.ecommerce.vo.AsanMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>构建消息驱动</h1>
 *
 * @author mingkai yun
 * @date 2022/2/12
 */
@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {

    private final DefaultSendService defaultSendService;
    private final AsanSendService asanSendService;

    public MessageController(DefaultSendService defaultSendService,
                             AsanSendService asanSendService) {
        this.defaultSendService = defaultSendService;
        this.asanSendService = asanSendService;
    }

    /**
     * <h2>默认信道</h2>
     */
    @GetMapping("/default")
    public void defaultSend() {
        defaultSendService.sendMessage(AsanMessage.defaultMessage());
    }

    /**
     * <h2>自定义信道</h2>
     */
    @GetMapping("/asan")
    public void asanSend() {
        asanSendService.sendMessage(AsanMessage.defaultMessage());
    }
}
