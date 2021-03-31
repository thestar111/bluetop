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

import com.bluetop.engin.api.service.WebClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/3/31 21:25
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@RestController
public class WorkflowApi {

    @Autowired
    private WebClientService webClientService;

    /**
     * 创建流程
     *
     * @param flowId
     * @param userId
     * @return
     */
    @PostMapping(value = "/create/flow")
    public String createWorkflow(@RequestParam("flowId") String flowId, @RequestParam("userId") String userId) {
        return webClientService.sendWsdlWebService(flowId, userId);
    }

    /**
     * 获取流程信息
     *
     */
    @GetMapping(value = "flow/info")
    public void getFlow() {
        webClientService.getWorkflowInfo();
    }
}
