/**
 * 文 件 名:  WorkflowLogApi
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  4:59
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.api;

import com.bluetop.engin.api.bean.WorkflowLog;
import com.bluetop.engin.api.service.WorkflowLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <流程日志管理>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/6 4:59
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Api(tags = "流程日志管理")
@RestController
public class WorkflowLogApi {

    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * 获取流程日志
     *
     * @return
     */
    @ApiOperation(value = "获取流程日志列表")
    @GetMapping(value = "/workflow/log/list")
    public List<WorkflowLog> listWorkflow() {
        return workflowLogService.list();
    }
}
