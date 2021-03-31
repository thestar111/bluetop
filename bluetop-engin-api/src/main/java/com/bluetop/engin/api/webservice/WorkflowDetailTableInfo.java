
package com.bluetop.engin.api.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;WorkflowDetailTableInfo complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="WorkflowDetailTableInfo"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="tableDBName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="tableFieldName" type="{webservices.services.weaver.com.cn}ArrayOfString" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="tableTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowRequestTableRecords" type="{http://webservices.workflow.weaver}ArrayOfWorkflowRequestTableRecord" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowDetailTableInfo", namespace = "http://webservices.workflow.weaver", propOrder = {
    "tableDBName",
    "tableFieldName",
    "tableTitle",
    "workflowRequestTableRecords"
})
public class WorkflowDetailTableInfo {

    @XmlElement(nillable = true)
    protected String tableDBName;
    @XmlElement(nillable = true)
    protected ArrayOfString tableFieldName;
    @XmlElement(nillable = true)
    protected String tableTitle;
    @XmlElement(nillable = true)
    protected ArrayOfWorkflowRequestTableRecord workflowRequestTableRecords;

    /**
     * 获取tableDBName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableDBName() {
        return tableDBName;
    }

    /**
     * 设置tableDBName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableDBName(String value) {
        this.tableDBName = value;
    }

    /**
     * 获取tableFieldName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getTableFieldName() {
        return tableFieldName;
    }

    /**
     * 设置tableFieldName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setTableFieldName(ArrayOfString value) {
        this.tableFieldName = value;
    }

    /**
     * 获取tableTitle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableTitle() {
        return tableTitle;
    }

    /**
     * 设置tableTitle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableTitle(String value) {
        this.tableTitle = value;
    }

    /**
     * 获取workflowRequestTableRecords属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWorkflowRequestTableRecord }
     *     
     */
    public ArrayOfWorkflowRequestTableRecord getWorkflowRequestTableRecords() {
        return workflowRequestTableRecords;
    }

    /**
     * 设置workflowRequestTableRecords属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWorkflowRequestTableRecord }
     *     
     */
    public void setWorkflowRequestTableRecords(ArrayOfWorkflowRequestTableRecord value) {
        this.workflowRequestTableRecords = value;
    }

}
