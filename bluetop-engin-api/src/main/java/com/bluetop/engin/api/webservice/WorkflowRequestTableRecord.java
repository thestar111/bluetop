
package com.bluetop.engin.api.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;WorkflowRequestTableRecord complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="WorkflowRequestTableRecord"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="recordOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="workflowRequestTableFields" type="{http://webservices.workflow.weaver}ArrayOfWorkflowRequestTableField" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowRequestTableRecord", namespace = "http://webservices.workflow.weaver", propOrder = {
    "recordOrder",
    "workflowRequestTableFields"
})
public class WorkflowRequestTableRecord {

    protected Integer recordOrder;
    @XmlElementRef(name = "workflowRequestTableFields", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWorkflowRequestTableField> workflowRequestTableFields;

    /**
     * 获取recordOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecordOrder() {
        return recordOrder;
    }

    /**
     * 设置recordOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecordOrder(Integer value) {
        this.recordOrder = value;
    }

    /**
     * 获取workflowRequestTableFields属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestTableField }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWorkflowRequestTableField> getWorkflowRequestTableFields() {
        return workflowRequestTableFields;
    }

    /**
     * 设置workflowRequestTableFields属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestTableField }{@code >}
     *     
     */
    public void setWorkflowRequestTableFields(JAXBElement<ArrayOfWorkflowRequestTableField> value) {
        this.workflowRequestTableFields = value;
    }

}
