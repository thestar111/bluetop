
package com.bluetop.engin.api.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;WorkflowRequestInfo complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="WorkflowRequestInfo"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="canEdit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="canView" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="creatorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="creatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="currentNodeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="currentNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="forwardButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="isnextflow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="lastOperateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="lastOperatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="mustInputRemark" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="needAffirmance" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiveTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="rejectButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="requestLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="requestName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="secLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="subbackButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="submitButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="subnobackButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowBaseInfo" type="{http://webservices.workflow.weaver}WorkflowBaseInfo" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowDetailTableInfos" type="{http://webservices.workflow.weaver}ArrayOfWorkflowDetailTableInfo" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowHtmlShow" type="{webservices.services.weaver.com.cn}ArrayOfString" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowHtmlTemplete" type="{webservices.services.weaver.com.cn}ArrayOfString" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowMainTableInfo" type="{http://webservices.workflow.weaver}WorkflowMainTableInfo" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowPhrases" type="{webservices.services.weaver.com.cn}ArrayOfArrayOfString" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowRequestLogs" type="{http://webservices.workflow.weaver}ArrayOfWorkflowRequestLog" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowRequestInfo", namespace = "http://webservices.workflow.weaver", propOrder = {
    "canEdit",
    "canView",
    "createTime",
    "creatorId",
    "creatorName",
    "currentNodeId",
    "currentNodeName",
    "forwardButtonName",
    "isnextflow",
    "lastOperateTime",
    "lastOperatorName",
    "messageType",
    "mustInputRemark",
    "needAffirmance",
    "receiveTime",
    "rejectButtonName",
    "remark",
    "requestId",
    "requestLevel",
    "requestName",
    "secLevel",
    "status",
    "subbackButtonName",
    "submitButtonName",
    "subnobackButtonName",
    "workflowBaseInfo",
    "workflowDetailTableInfos",
    "workflowHtmlShow",
    "workflowHtmlTemplete",
    "workflowMainTableInfo",
    "workflowPhrases",
    "workflowRequestLogs"
})
public class WorkflowRequestInfo {

    protected Boolean canEdit;
    protected Boolean canView;
    @XmlElement(nillable = true)
    protected String createTime;
    @XmlElement(nillable = true)
    protected String creatorId;
    @XmlElement(nillable = true)
    protected String creatorName;
    @XmlElement(nillable = true)
    protected String currentNodeId;
    @XmlElement(nillable = true)
    protected String currentNodeName;
    @XmlElement(nillable = true)
    protected String forwardButtonName;
    @XmlElement(nillable = true)
    protected String isnextflow;
    @XmlElement(nillable = true)
    protected String lastOperateTime;
    @XmlElement(nillable = true)
    protected String lastOperatorName;
    @XmlElement(nillable = true)
    protected String messageType;
    protected Boolean mustInputRemark;
    protected Boolean needAffirmance;
    @XmlElement(nillable = true)
    protected String receiveTime;
    @XmlElement(nillable = true)
    protected String rejectButtonName;
    @XmlElement(nillable = true)
    protected String remark;
    @XmlElement(nillable = true)
    protected String requestId;
    @XmlElement(nillable = true)
    protected String requestLevel;
    @XmlElement(nillable = true)
    protected String requestName;
    @XmlElement(nillable = true)
    protected String secLevel;
    @XmlElement(nillable = true)
    protected String status;
    @XmlElement(nillable = true)
    protected String subbackButtonName;
    @XmlElement(nillable = true)
    protected String submitButtonName;
    @XmlElement(nillable = true)
    protected String subnobackButtonName;
    @XmlElement(nillable = true)
    protected WorkflowBaseInfo workflowBaseInfo;
    @XmlElement(nillable = true)
    protected ArrayOfWorkflowDetailTableInfo workflowDetailTableInfos;
    @XmlElement(nillable = true)
    protected ArrayOfString workflowHtmlShow;
    @XmlElement(nillable = true)
    protected ArrayOfString workflowHtmlTemplete;
    @XmlElement(nillable = true)
    protected WorkflowMainTableInfo workflowMainTableInfo;
    @XmlElement(nillable = true)
    protected ArrayOfArrayOfString workflowPhrases;
    @XmlElement(nillable = true)
    protected ArrayOfWorkflowRequestLog workflowRequestLogs;

    /**
     * 获取canEdit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanEdit() {
        return canEdit;
    }

    /**
     * 设置canEdit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanEdit(Boolean value) {
        this.canEdit = value;
    }

    /**
     * 获取canView属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanView() {
        return canView;
    }

    /**
     * 设置canView属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanView(Boolean value) {
        this.canView = value;
    }

    /**
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTime(String value) {
        this.createTime = value;
    }

    /**
     * 获取creatorId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置creatorId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorId(String value) {
        this.creatorId = value;
    }

    /**
     * 获取creatorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 设置creatorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorName(String value) {
        this.creatorName = value;
    }

    /**
     * 获取currentNodeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentNodeId() {
        return currentNodeId;
    }

    /**
     * 设置currentNodeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentNodeId(String value) {
        this.currentNodeId = value;
    }

    /**
     * 获取currentNodeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentNodeName() {
        return currentNodeName;
    }

    /**
     * 设置currentNodeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentNodeName(String value) {
        this.currentNodeName = value;
    }

    /**
     * 获取forwardButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForwardButtonName() {
        return forwardButtonName;
    }

    /**
     * 设置forwardButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForwardButtonName(String value) {
        this.forwardButtonName = value;
    }

    /**
     * 获取isnextflow属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsnextflow() {
        return isnextflow;
    }

    /**
     * 设置isnextflow属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsnextflow(String value) {
        this.isnextflow = value;
    }

    /**
     * 获取lastOperateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastOperateTime() {
        return lastOperateTime;
    }

    /**
     * 设置lastOperateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastOperateTime(String value) {
        this.lastOperateTime = value;
    }

    /**
     * 获取lastOperatorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastOperatorName() {
        return lastOperatorName;
    }

    /**
     * 设置lastOperatorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastOperatorName(String value) {
        this.lastOperatorName = value;
    }

    /**
     * 获取messageType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * 设置messageType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageType(String value) {
        this.messageType = value;
    }

    /**
     * 获取mustInputRemark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMustInputRemark() {
        return mustInputRemark;
    }

    /**
     * 设置mustInputRemark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMustInputRemark(Boolean value) {
        this.mustInputRemark = value;
    }

    /**
     * 获取needAffirmance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedAffirmance() {
        return needAffirmance;
    }

    /**
     * 设置needAffirmance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedAffirmance(Boolean value) {
        this.needAffirmance = value;
    }

    /**
     * 获取receiveTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置receiveTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiveTime(String value) {
        this.receiveTime = value;
    }

    /**
     * 获取rejectButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRejectButtonName() {
        return rejectButtonName;
    }

    /**
     * 设置rejectButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRejectButtonName(String value) {
        this.rejectButtonName = value;
    }

    /**
     * 获取remark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置remark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * 获取requestId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 设置requestId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * 获取requestLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestLevel() {
        return requestLevel;
    }

    /**
     * 设置requestLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestLevel(String value) {
        this.requestLevel = value;
    }

    /**
     * 获取requestName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestName() {
        return requestName;
    }

    /**
     * 设置requestName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestName(String value) {
        this.requestName = value;
    }

    /**
     * 获取secLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecLevel() {
        return secLevel;
    }

    /**
     * 设置secLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecLevel(String value) {
        this.secLevel = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * 获取subbackButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubbackButtonName() {
        return subbackButtonName;
    }

    /**
     * 设置subbackButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubbackButtonName(String value) {
        this.subbackButtonName = value;
    }

    /**
     * 获取submitButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitButtonName() {
        return submitButtonName;
    }

    /**
     * 设置submitButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitButtonName(String value) {
        this.submitButtonName = value;
    }

    /**
     * 获取subnobackButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubnobackButtonName() {
        return subnobackButtonName;
    }

    /**
     * 设置subnobackButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubnobackButtonName(String value) {
        this.subnobackButtonName = value;
    }

    /**
     * 获取workflowBaseInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WorkflowBaseInfo }
     *     
     */
    public WorkflowBaseInfo getWorkflowBaseInfo() {
        return workflowBaseInfo;
    }

    /**
     * 设置workflowBaseInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowBaseInfo }
     *     
     */
    public void setWorkflowBaseInfo(WorkflowBaseInfo value) {
        this.workflowBaseInfo = value;
    }

    /**
     * 获取workflowDetailTableInfos属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWorkflowDetailTableInfo }
     *     
     */
    public ArrayOfWorkflowDetailTableInfo getWorkflowDetailTableInfos() {
        return workflowDetailTableInfos;
    }

    /**
     * 设置workflowDetailTableInfos属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWorkflowDetailTableInfo }
     *     
     */
    public void setWorkflowDetailTableInfos(ArrayOfWorkflowDetailTableInfo value) {
        this.workflowDetailTableInfos = value;
    }

    /**
     * 获取workflowHtmlShow属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getWorkflowHtmlShow() {
        return workflowHtmlShow;
    }

    /**
     * 设置workflowHtmlShow属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setWorkflowHtmlShow(ArrayOfString value) {
        this.workflowHtmlShow = value;
    }

    /**
     * 获取workflowHtmlTemplete属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getWorkflowHtmlTemplete() {
        return workflowHtmlTemplete;
    }

    /**
     * 设置workflowHtmlTemplete属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setWorkflowHtmlTemplete(ArrayOfString value) {
        this.workflowHtmlTemplete = value;
    }

    /**
     * 获取workflowMainTableInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WorkflowMainTableInfo }
     *     
     */
    public WorkflowMainTableInfo getWorkflowMainTableInfo() {
        return workflowMainTableInfo;
    }

    /**
     * 设置workflowMainTableInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowMainTableInfo }
     *     
     */
    public void setWorkflowMainTableInfo(WorkflowMainTableInfo value) {
        this.workflowMainTableInfo = value;
    }

    /**
     * 获取workflowPhrases属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfString }
     *     
     */
    public ArrayOfArrayOfString getWorkflowPhrases() {
        return workflowPhrases;
    }

    /**
     * 设置workflowPhrases属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfString }
     *     
     */
    public void setWorkflowPhrases(ArrayOfArrayOfString value) {
        this.workflowPhrases = value;
    }

    /**
     * 获取workflowRequestLogs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWorkflowRequestLog }
     *     
     */
    public ArrayOfWorkflowRequestLog getWorkflowRequestLogs() {
        return workflowRequestLogs;
    }

    /**
     * 设置workflowRequestLogs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWorkflowRequestLog }
     *     
     */
    public void setWorkflowRequestLogs(ArrayOfWorkflowRequestLog value) {
        this.workflowRequestLogs = value;
    }

}
