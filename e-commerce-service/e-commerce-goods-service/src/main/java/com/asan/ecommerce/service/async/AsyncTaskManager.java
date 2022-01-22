package com.asan.ecommerce.service.async;

import com.asan.ecommerce.constant.AsyncTaskStatusEnum;
import com.asan.ecommerce.goods.GoodsInfo;
import com.asan.ecommerce.vo.AsyncTaskInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <h1>异步任务执行管理器</h1>
 * 对异步任务进行包装管理, 记录并塞入异步任务执行信息
 *
 * @author mingkai yun
 * @date 2022/1/22
 */
@Slf4j
@Component
public class AsyncTaskManager {

    /**
     * 异步任务执行信息容器
     */
    private final Map<String, AsyncTaskInfo> taskContainer =
            new HashMap<>(16);

    private final IAsyncService asyncService;

    public AsyncTaskManager(IAsyncService asyncService) {
        this.asyncService = asyncService;
    }

    /**
     * <h2>初始化异步任务</h2>
     */
    public AsyncTaskInfo initTask() {

        AsyncTaskInfo taskInfo = new AsyncTaskInfo();
        // 设置一个唯一的异步任务 id, 只要唯一即可
        taskInfo.setTaskId(UUID.randomUUID().toString());
        taskInfo.setStatus(AsyncTaskStatusEnum.STARTED);
        taskInfo.setStartTime(new Date());

        // 初始化的时候就要把异步任务执行信息放入到存储容器中
        taskContainer.put(taskInfo.getTaskId(), taskInfo);
        return taskInfo;
    }

    /**
     * <h2>提交异步任务</h2>
     *
     * @param goodsInfos 详细的商品信息
     */
    public AsyncTaskInfo submit(List<GoodsInfo> goodsInfos) {

        // 初始化一个异步任务的监控信息
        AsyncTaskInfo taskInfo = initTask();
        asyncService.asyncImportGoods(goodsInfos, taskInfo.getTaskId());
        return taskInfo;
    }

    /**
     * <h2>设置异步任务执行状态信息</h2>
     *
     * @param taskInfo 异步任务信息
     */
    public void setTaskInfo(AsyncTaskInfo taskInfo) {
        taskContainer.put(taskInfo.getTaskId(), taskInfo);
    }

    /**
     * <h2>获取异步任务执行状态信息</h2>
     *
     * @param taskId 异步任务ID
     */
    public AsyncTaskInfo getTaskInfo(String taskId) {
        return taskContainer.get(taskId);
    }
}
