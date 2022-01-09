package com.asan.ecommerce.notifier;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractEventNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * <h1>自定义告警</h1>
 *
 * @author mingkai yun
 * @date 2022/1/9
 */
@Slf4j
@Component
@SuppressWarnings("all")
public class AsanNotifier extends AbstractEventNotifier {
    protected AsanNotifier(InstanceRepository repository) {
        super(repository);
    }

    /**
     * <h2>实现对事件的通知</h2>
     *
     * @param event    实例发生的事件
     * @param instance 实例的具体信息
     * @return {@link Mono}
     */
    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {

        return Mono.fromRunnable(() -> {
            // 判断是否是实例的状态发生变化，如果状态没有发生改变就打印一下实例的信息和实例事件的类型，例如刚启动admin服务，那么它就会发生状态的改变
            // 启动好了之后，需要注册到nacos上，但是状态没有发生改变，只是发生了注册的行为，所以也被记录下来
            if (event instanceof InstanceStatusChangedEvent) {
                log.info("Instance Status Change: [{}], [{}], [{}]",
                        instance.getRegistration().getName(), event.getInstance(),
                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
            } else {
                log.info("Instance Info: [{}], [{}], [{}]",
                        instance.getRegistration().getName(), event.getInstance(),
                        event.getType());
            }

        });
    }
}
