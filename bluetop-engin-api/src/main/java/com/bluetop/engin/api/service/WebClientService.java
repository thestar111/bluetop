/**
 * 文 件 名:  WebClientService
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:58
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.service;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.bluetop.engin.api.webservice.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/3/30 21:58
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Service
public class WebClientService {

    /**
     * 调用WebService接口
     *
     * @param workflowId
     * @param userId
     * @return
     */
    public String sendWsdlWebService(String workflowId, String userId) {
        log.info("--------调用webservice查询接口begin-------");
        DoCreateWorkflowRequestResponse doCreateWorkflowRequestResponse = null;
        String requestId = null;
        URL url;
        try {
            url = new URL("http://180.167.215.157:30182/services/WorkflowService?wsdl");
            //Qnameqname是qualified name 的简写
            QName qname = new QName("webservices.services.weaver.com.cn", "WorkflowService");
            WorkflowService ss = new WorkflowService(url, qname);
            WorkflowServicePortType port = ss.getWorkflowServiceHttpPort();

            ObjectFactory objFac = new ObjectFactory();
            WorkflowRequestInfo wri = objFac.createWorkflowRequestInfo();
            wri.setCreatorId(userId);
            wri.setRequestName("周平测试-合同审批");
            wri.setRequestLevel("0");

            WorkflowBaseInfo wbi = objFac.createWorkflowBaseInfo();
            wbi.setWorkflowId(workflowId);
            requestId = port.doCreateWorkflowRequest(wri, Integer.valueOf(userId));
        } catch (Exception e) {
            log.error("调用webservice查询接口异常");
            e.printStackTrace();
        }
        log.info("--------调用webservice查询接口end-------");
        return requestId;
    }

    /**
     * 获取流程信息
     */
    public void getWorkflowInfo() {
        URL url;
        try {
            url = new URL("http://180.167.215.157:30182/services/WorkflowService?wsdl");
            //Qnameqname是qualified name 的简写
            QName qname = new QName("webservices.services.weaver.com.cn", "WorkflowService");
            WorkflowService ss = new WorkflowService(url, qname);
            WorkflowServicePortType port = ss.getWorkflowServiceHttpPort();

            ObjectFactory objFac = new ObjectFactory();
            ArrayOfString arrayOfString = objFac.createArrayOfString();
            arrayOfString.getString();
            ArrayOfWorkflowRequestInfo arrayOfWorkflowRequestInfo = port.getProcessedWorkflowRequestList(1, 10, 10, 162, arrayOfString);
            List<WorkflowRequestInfo> workflowRequestInfos = arrayOfWorkflowRequestInfo.getWorkflowRequestInfo();
            log.info("流程返回信息：{}", JSONUtil.toJsonStr(workflowRequestInfos));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
