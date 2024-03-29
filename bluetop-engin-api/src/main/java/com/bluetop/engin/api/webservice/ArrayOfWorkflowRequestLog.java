
package com.bluetop.engin.api.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;ArrayOfWorkflowRequestLog complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfWorkflowRequestLog"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="WorkflowRequestLog" type="{http://webservices.workflow.weaver}WorkflowRequestLog" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWorkflowRequestLog", namespace = "http://webservices.workflow.weaver", propOrder = {
    "workflowRequestLog"
})
public class ArrayOfWorkflowRequestLog {

    @XmlElement(name = "WorkflowRequestLog", nillable = true)
    protected List<WorkflowRequestLog> workflowRequestLog;

    /**
     * Gets the value of the workflowRequestLog property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the workflowRequestLog property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getWorkflowRequestLog().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link WorkflowRequestLog }
     * 
     * 
     */
    public List<WorkflowRequestLog> getWorkflowRequestLog() {
        if (workflowRequestLog == null) {
            workflowRequestLog = new ArrayList<WorkflowRequestLog>();
        }
        return this.workflowRequestLog;
    }

}
