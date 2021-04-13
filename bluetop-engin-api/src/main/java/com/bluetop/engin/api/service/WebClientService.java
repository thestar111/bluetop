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

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.bluetop.engin.api.bean.Workflow;
import com.bluetop.engin.api.bean.WorkflowLog;
import com.bluetop.engin.api.client.WorkflowCallbackClient;
import com.bluetop.engin.api.client.request.CallbackRequest;
import com.bluetop.engin.api.config.CommonCacheBean;
import com.bluetop.engin.api.cons.Constans;
import com.bluetop.engin.api.cons.WorkflowStatus;
import com.bluetop.engin.api.dao.WorkflowLogDao;
import com.bluetop.engin.api.model.NameAndValue;
import com.bluetop.engin.api.model.TableDetailInfo;
import com.bluetop.engin.api.param.CreateWorkflowRequest;
import com.bluetop.engin.api.webservice.*;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.Callback;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <客户端工具>
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

    @Autowired
    private CommonCacheBean commonCacheBean;

    @Autowired
    private WorkflowLogDao workflowLogDao;

    @Autowired
    private WorkflowCallbackClient workflowCallbackClient;

    @Value("${machine.number:1}")
    private String machine;

    @Value("${key:c7bccb45453a9d22}")
    private String key;

    /**
     * 创建流程
     *
     * @param createWorkflowRequest
     * @return
     */
    public String createWorkflow(CreateWorkflowRequest createWorkflowRequest) {
        Workflow workflow = commonCacheBean.getWorkflow(createWorkflowRequest.getWorkflowId());
        if (Objects.isNull(workflow)) {
            log.error("【{}】 workflow not exist. workflowId : {}", getClass().getSimpleName(), createWorkflowRequest.getWorkflowId());
            throw new RuntimeException("流程不存在");
        }
        String requestId = StringUtils.EMPTY;
        try {
            URL url = new URL(commonCacheBean.getConfig(Constans.ConfigKey.WSDL_URL_KEY));
            // Qname是qualified name的简写
            QName qname = new QName("webservices.services.weaver.com.cn", "WorkflowService");
            WorkflowService workflowService = new WorkflowService(url, qname);
            WorkflowServicePortType port = workflowService.getWorkflowServiceHttpPort();

            ObjectFactory objFac = new ObjectFactory();
            WorkflowRequestInfo wri = objFac.createWorkflowRequestInfo();
            wri.setCreatorId(createWorkflowRequest.getUserId());
            wri.setRequestName(workflow.getWorkflowName());
            wri.setRequestLevel(createWorkflowRequest.getRequestLevel());

            // 1. 流程主表信息
            if (!Objects.isNull(createWorkflowRequest.getWorkflowMainTables())) {
                WorkflowMainTableInfo workflowMainTableInfo = createWorkflowMainTable(createWorkflowRequest.getWorkflowMainTables(), objFac);
                wri.setWorkflowMainTableInfo(workflowMainTableInfo);
            }

            // 2. 流程详细信息
            List<TableDetailInfo> tableDetailInfos = createWorkflowRequest.getWorkflowDetailTables();
            if (CollectionUtil.isNotEmpty(tableDetailInfos)) {
                Collections.sort(tableDetailInfos);
                ArrayOfWorkflowDetailTableInfo arrayOfWorkflowDetailTableInfo = objFac.createArrayOfWorkflowDetailTableInfo();
                List<WorkflowDetailTableInfo> workflowDetailTableInfos = arrayOfWorkflowDetailTableInfo.getWorkflowDetailTableInfo();
                tableDetailInfos.stream().forEach(tableDetailInfo -> {
                    List<List<NameAndValue>> tableMaps =  tableDetailInfo.getTableInfos();
                    workflowDetailTableInfos.add(createDetailTableInfo(objFac, tableMaps));
                });
                wri.setWorkflowDetailTableInfos(arrayOfWorkflowDetailTableInfo);
            }

            // 3. 流程基础信息
            WorkflowBaseInfo wbi = objFac.createWorkflowBaseInfo();
            wbi.setWorkflowId(createWorkflowRequest.getWorkflowId());
            wri.setWorkflowBaseInfo(wbi);
            log.info("【{}】process workflow begin. request : =========================>>>> {}", getClass().getSimpleName(), JSONUtil.toJsonStr(wri));
            requestId = port.doCreateWorkflowRequest(wri, Integer.valueOf(createWorkflowRequest.getUserId()));
            if (StringUtils.isNotEmpty(requestId) && Integer.valueOf(requestId) > 0) {
                WorkflowLog workflowLog = new WorkflowLog();
                workflowLog.setRequestId(requestId);
                workflowLog.setUserId(createWorkflowRequest.getUserId());
                workflowLog.setRetryMaxTime(3);
                workflowLog.setRetryTime(0);
                workflowLog.setStatus("NEW");
                workflowLog.setMachine(machine);
                workflowLog.setWorkflowId(workflow.getWorkflowId());
                workflowLog.setWorkflowName(workflow.getWorkflowName());
                workflowLogDao.addLog(workflowLog);
            }
        } catch (Exception e) {
            log.error("【WebClientService】 call workflow service error.", e);
            throw new RuntimeException("调用创建流程服务异常");
        }
        log.info("【{}】process workflow success. return requestId : =========================<<<< {}", getClass().getSimpleName(), requestId);
        return requestId;
    }

    /**
     * 创建主流程表单信息
     *
     * @param mainTableMap
     * @param objFac
     * @return
     */
    private WorkflowMainTableInfo createWorkflowMainTable(List<NameAndValue> mainTableMap, ObjectFactory objFac) {
        WorkflowMainTableInfo workflowMainTableInfo = objFac.createWorkflowMainTableInfo();
        ArrayOfWorkflowRequestTableRecord arrayOfWorkflowRequestTableRecord = objFac.createArrayOfWorkflowRequestTableRecord();
        workflowMainTableInfo.setRequestRecords(arrayOfWorkflowRequestTableRecord);
        List<WorkflowRequestTableRecord> workflowRequestTableRecords = arrayOfWorkflowRequestTableRecord.getWorkflowRequestTableRecord();
        WorkflowRequestTableRecord workflowRequestTableRecord = objFac.createWorkflowRequestTableRecord();
        workflowRequestTableRecords.add(workflowRequestTableRecord);
        ArrayOfWorkflowRequestTableField arrayOfWorkflowRequestTableField = objFac.createArrayOfWorkflowRequestTableField();
        workflowRequestTableRecord.setWorkflowRequestTableFields(arrayOfWorkflowRequestTableField);
        List<WorkflowRequestTableField> workflowRequestTableFields = arrayOfWorkflowRequestTableField.getWorkflowRequestTableField();
        for (NameAndValue nameAndValue :mainTableMap) {
            workflowRequestTableFields.add(createWorkflowRequestTableField(nameAndValue));
        }
        return workflowMainTableInfo;
    }

    /**
     * 创建明细表
     *
     * @param objFac
     * @param fields
     * @return
     */
    private WorkflowDetailTableInfo createDetailTableInfo(ObjectFactory objFac, List<List<NameAndValue>> fields) {
        WorkflowDetailTableInfo workflowDetailTableInfo = new WorkflowDetailTableInfo();
        if (CollectionUtil.isEmpty(fields)) {
            return workflowDetailTableInfo;
        }
        ArrayOfWorkflowRequestTableRecord arrayOfWorkflowRequestTableRecord = objFac.createArrayOfWorkflowRequestTableRecord();
        List<WorkflowRequestTableRecord> workflowRequestDetailTableRecords = arrayOfWorkflowRequestTableRecord.getWorkflowRequestTableRecord();
        WorkflowRequestTableRecord workflowRequestTableRecord = objFac.createWorkflowRequestTableRecord();
        ArrayOfWorkflowRequestTableField arrayOfWorkflowRequestTableField = objFac.createArrayOfWorkflowRequestTableField();
        List<WorkflowRequestTableField> workflowRequestTableFields = arrayOfWorkflowRequestTableField.getWorkflowRequestTableField();
        for (List<NameAndValue> field : fields) {
            workflowRequestTableFields.addAll(createWorkflowRequestTableField(field));
        }
        workflowRequestTableRecord.setWorkflowRequestTableFields(arrayOfWorkflowRequestTableField);
        workflowRequestDetailTableRecords.add(workflowRequestTableRecord);
        workflowDetailTableInfo.setWorkflowRequestTableRecords(arrayOfWorkflowRequestTableRecord);
        return workflowDetailTableInfo;
    }

    /**
     * 创建明细单
     *
     * @param filedNameAndValue
     * @return
     */
    public List<WorkflowRequestTableField> createWorkflowRequestTableField(List<NameAndValue> filedNameAndValue) {
        if (Objects.isNull(filedNameAndValue)) {
            Lists.newArrayList();
        }
        List<WorkflowRequestTableField> workflowRequestTableFields = Lists.newArrayList();
        for (NameAndValue nameAndValue : filedNameAndValue) {
            WorkflowRequestTableField workflowRequestTableField = new WorkflowRequestTableField();
            workflowRequestTableField.setFieldName(nameAndValue.getName());
            workflowRequestTableField.setFieldValue(nameAndValue.getValue());
            if (nameAndValue.isFile()) {
                workflowRequestTableField.setFieldType(String.format("http:%s", nameAndValue.getFileName()));
            }
            workflowRequestTableField.setEdit(true);
            workflowRequestTableField.setView(true);
            workflowRequestTableFields.add(workflowRequestTableField);
        }
        return workflowRequestTableFields;
    }

    /**
     * 创建工作流表单属性
     *
     * @param nameAndValue  键值对
     * @return
     */
    private WorkflowRequestTableField createWorkflowRequestTableField(NameAndValue nameAndValue) {
        WorkflowRequestTableField workflowRequestTableField = new WorkflowRequestTableField();
        workflowRequestTableField.setFieldName(nameAndValue.getName());
        workflowRequestTableField.setFieldValue(nameAndValue.getValue());
        if (nameAndValue.isFile()) {
            workflowRequestTableField.setFieldType("http:" + nameAndValue.getFileName());
        }
        workflowRequestTableField.setView(true);
        workflowRequestTableField.setEdit(true);
        return workflowRequestTableField;
    }

    /**
     * 同步流程信息
     *
     * @param requestId
     * @param userId
     */
    public void syncWorkflowInfo(int requestId, int userId) {
        URL url;
        CallbackRequest request = null;
        Map<String, Object> map = null;
        try {
            url = new URL(commonCacheBean.getConfig(Constans.ConfigKey.WSDL_URL_KEY));
            //Qnameqname是qualified name 的简写
            QName qname = new QName("webservices.services.weaver.com.cn", "WorkflowService");
            WorkflowService workflowService = new WorkflowService(url, qname);
            WorkflowServicePortType port = workflowService.getWorkflowServiceHttpPort();
            ObjectFactory objFac = new ObjectFactory();
            ArrayOfString arrayOfString = objFac.createArrayOfString();
            arrayOfString.getString();
            WorkflowRequestInfo workflowRequestInfo = port.getWorkflowRequest(requestId, userId, 0);
            switch (workflowRequestInfo.getCurrentNodeName())
            {
                case "归档" :
                    log.info("【{}】 workflow request_id : {} had complete.", getClass().getSimpleName(), requestId);
                    workflowLogDao.modifyWorkflow(String.valueOf(requestId), WorkflowStatus.COMPLETE.name());
                    request = new CallbackRequest();
                    request.setApprove_status(0);
                    request.setTimestamp(System.currentTimeMillis() + "");
                    request.setFlow_record_id(requestId);
                    request.setFlow_form(JSONUtil.toJsonStr(workflowRequestInfo));
                    request.setWorkflow_id(Integer.valueOf(workflowRequestInfo.getWorkflowBaseInfo().getWorkflowId()));
                    request.buildSign(key);
                    map = workflowCallbackClient.callback(request);
                    log.info("[{}] callback return result : {}", getClass().getSimpleName(), JSONUtil.toJsonStr(map));
                    break;
                case "制单人" :
                    log.info("【{}】 workflow request_id : {} had complete.", getClass().getSimpleName(), requestId);
                    workflowLogDao.modifyWorkflow(String.valueOf(requestId), WorkflowStatus.REJECT.name());
                    request = new CallbackRequest();
                    request.setApprove_status(1);
                    request.setTimestamp(System.currentTimeMillis() + "");
                    request.setFlow_record_id(requestId);
                    request.setFlow_form(JSONUtil.toJsonStr(workflowRequestInfo));
                    request.setWorkflow_id(Integer.valueOf(workflowRequestInfo.getWorkflowBaseInfo().getWorkflowId()));
                    request.buildSign(key);
                    map = workflowCallbackClient.callback(request);
                    log.info("[{}] callback return result : {}", getClass().getSimpleName(), JSONUtil.toJsonStr(map));
                    break;
                default:
                    break;
            }
            log.info("流程返回信息：{}", JSONUtil.toJsonStr(workflowRequestInfo));
        } catch (Exception e) {
            log.error("【WebClientService】 sync workflow error.", e);
        }
    }

    /**
     * 获取流程信息
     *
     * @param requestId
     * @param userId
     * @return
     */
    public WorkflowLog getWorkflowInfo(int requestId, int userId) {
        try {
            WorkflowLog workflowLog = workflowLogDao.getWorkflow(requestId, userId);
            log.info("流程返回信息：{}", JSONUtil.toJsonStr(workflowLog));
            return workflowLog;
        } catch (Exception e) {
            log.error("【WebClientService】 sync workflow error.", e);
        }
        return null;
    }
}
