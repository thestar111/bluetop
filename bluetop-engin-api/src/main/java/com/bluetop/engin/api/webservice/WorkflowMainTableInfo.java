
package com.bluetop.engin.api.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;WorkflowMainTableInfo complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="WorkflowMainTableInfo"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="requestRecords" type="{http://webservices.workflow.weaver}ArrayOfWorkflowRequestTableRecord" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="tableDBName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowMainTableInfo", namespace = "http://webservices.workflow.weaver", propOrder = {
    "requestRecords",
    "tableDBName"
})
public class WorkflowMainTableInfo {

    @XmlElementRef(name = "requestRecords", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWorkflowRequestTableRecord> requestRecords;
    @XmlElementRef(name = "tableDBName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tableDBName;

    /**
     * 获取requestRecords属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestTableRecord }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWorkflowRequestTableRecord> getRequestRecords() {
        return requestRecords;
    }

    /**
     * 设置requestRecords属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestTableRecord }{@code >}
     *     
     */
    public void setRequestRecords(JAXBElement<ArrayOfWorkflowRequestTableRecord> value) {
        this.requestRecords = value;
    }

    /**
     * 获取tableDBName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTableDBName() {
        return tableDBName;
    }

    /**
     * 设置tableDBName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTableDBName(JAXBElement<String> value) {
        this.tableDBName = value;
    }

}
