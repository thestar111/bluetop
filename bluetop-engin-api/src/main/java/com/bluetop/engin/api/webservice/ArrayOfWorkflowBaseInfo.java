
package com.bluetop.engin.api.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;ArrayOfWorkflowBaseInfo complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfWorkflowBaseInfo"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="WorkflowBaseInfo" type="{http://webservices.workflow.weaver}WorkflowBaseInfo" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWorkflowBaseInfo", namespace = "http://webservices.workflow.weaver", propOrder = {
    "workflowBaseInfo"
})
public class ArrayOfWorkflowBaseInfo {

    @XmlElement(name = "WorkflowBaseInfo", nillable = true)
    protected List<WorkflowBaseInfo> workflowBaseInfo;

    /**
     * Gets the value of the workflowBaseInfo property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the workflowBaseInfo property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getWorkflowBaseInfo().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link WorkflowBaseInfo }
     * 
     * 
     */
    public List<WorkflowBaseInfo> getWorkflowBaseInfo() {
        if (workflowBaseInfo == null) {
            workflowBaseInfo = new ArrayList<WorkflowBaseInfo>();
        }
        return this.workflowBaseInfo;
    }

}
