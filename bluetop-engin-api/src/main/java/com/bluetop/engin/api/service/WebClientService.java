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

import com.bluetop.engin.api.webservice.DoCreateWorkflowRequest;
import com.bluetop.engin.api.webservice.DoCreateWorkflowRequestResponse;
import com.bluetop.engin.api.webservice.WorkflowServicePortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.URL;

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
     * @param aaa
     * @param bbb
     * @return
     */
    public String sendWsdlWebService(String aaa, String bbb) {
        log.info("--------调用webservice查询接口begin-------");
        DoCreateWorkflowRequestResponse doCreateWorkflowRequestResponse = null;
        URL url;
        String json = "";
        try {

            url = new URL("");
            //Qnameqname是qualified name 的简写
            //2.构成：由名字空间(namespace)前缀(prefix)以及冒号(:),还有一个元素名称构成
            QName qname = new QName("webservices.services.weaver.com.cn", "WorkflowService");
            javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);                                 //*原文章链接：https://blog.csdn.net/qq_27471405/article/details/105275657     * 其他均为盗版，公众号：灵儿的笔记(zygxsq)
            WorkflowServicePortType workflowServicePortType = service.getPort(WorkflowServicePortType.class);
            workflowServicePortType.doCreateWorkflowRequest(null, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("--------调用webservice查询接口end-------");
        return json;
    }
}
