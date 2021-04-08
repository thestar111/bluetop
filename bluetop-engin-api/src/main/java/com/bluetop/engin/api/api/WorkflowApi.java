/**
 * 文 件 名:  WorkflowApi
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:25
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.api;

import com.bluetop.engin.api.bean.WorkflowLog;
import com.bluetop.engin.api.model.Result;
import com.bluetop.engin.api.param.CreateWorkflowRequest;
import com.bluetop.engin.api.service.WebClientService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/3/31 21:25
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Api(tags = "流程管理")
@Slf4j
@RestController
public class WorkflowApi {

    @Autowired
    private WebClientService webClientService;

    /**
     * 创建流程
     *
     * @param createWorkflowRequest
     * @return
     */
    @ApiOperation(value = "创建流程", notes = "创建流程")
    @PostMapping(value = "/create/flow")
    public Result<String> createWorkflow(@RequestBody CreateWorkflowRequest createWorkflowRequest) {
        String reqId = webClientService.createWorkflow(createWorkflowRequest);
        Result<String> result = new Result<>();
        result.setCode(0);
        result.setMsg("SUCCESS");
        result.setData(reqId);
        return result;
    }

    /**
     * 获取流程信息
     *
     */
    @ApiOperation(value = "获取流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name="requestId",value="流程请求ID",required=true, paramType="QueryString"),
            @ApiImplicitParam(name="userId",value="用户ID",required=true, paramType="QueryString")
    })
    @GetMapping(value = "flow/info")
    public Result<WorkflowLog> getFlow(@RequestParam("requestId") Integer requestId, @RequestParam("userId") Integer userId) {
        WorkflowLog workflowLog = webClientService.getWorkflowInfo(requestId, userId);
        Result<WorkflowLog> result = new Result<>();
        result.setCode(0);
        result.setMsg("SUCCESS");
        result.setData(workflowLog);
        return result;
    }
}
