/**
 * 文 件 名:  WorkflowLogSync
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  17:05
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.task;

import cn.hutool.core.collection.CollectionUtil;
import com.bluetop.engin.api.bean.WorkflowLog;
import com.bluetop.engin.api.dao.WorkflowLogDao;
import com.bluetop.engin.api.service.WebClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <工作流程审批任务>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/6 17:05
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Component
public class WorkflowLogSync {

    @Autowired
    private WorkflowLogDao workflowLogDao;

    @Autowired
    private WebClientService webClientService;

    @Value("${machine.number}")
    private String machine;

    /**
     * 同步工作流程
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void syncWorkflow() {
        long startTime = System.currentTimeMillis();
        int id = 0;
        List<WorkflowLog> workflowLogs = workflowLogDao.listById(id);
        while (CollectionUtil.isNotEmpty(workflowLogs)) {
            for (WorkflowLog workflowLog : workflowLogs) {
                webClientService.syncWorkflowInfo(Integer.valueOf(workflowLog.getRequestId()), Integer.valueOf(workflowLog.getUserId()));
            }
            id = workflowLogs.get(workflowLogs.size() - 1).getId();
            workflowLogs = workflowLogDao.listById(id);
        }
        log.info("[{}] sync workflow success. cost time ； {}", getClass().getSimpleName(), System.currentTimeMillis() - startTime);
    }
}
