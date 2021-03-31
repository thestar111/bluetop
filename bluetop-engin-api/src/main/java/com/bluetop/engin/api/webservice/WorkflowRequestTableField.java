
package com.bluetop.engin.api.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;WorkflowRequestTableField complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="WorkflowRequestTableField"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="browserurl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="edit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldDBType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldFormName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldHtmlType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldShowName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldShowValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fieldValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="filedHtmlShow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="mand" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="selectnames" type="{webservices.services.weaver.com.cn}ArrayOfString" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="selectvalues" type="{webservices.services.weaver.com.cn}ArrayOfString" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="view" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowRequestTableField", namespace = "http://webservices.workflow.weaver", propOrder = {
    "browserurl",
    "edit",
    "fieldDBType",
    "fieldFormName",
    "fieldHtmlType",
    "fieldId",
    "fieldName",
    "fieldOrder",
    "fieldShowName",
    "fieldShowValue",
    "fieldType",
    "fieldValue",
    "filedHtmlShow",
    "mand",
    "selectnames",
    "selectvalues",
    "view"
})
public class WorkflowRequestTableField {

    @XmlElement(nillable = true)
    protected String browserurl;
    protected Boolean edit;
    @XmlElement(nillable = true)
    protected String fieldDBType;
    @XmlElement(nillable = true)
    protected String fieldFormName;
    @XmlElement(nillable = true)
    protected String fieldHtmlType;
    @XmlElement(nillable = true)
    protected String fieldId;
    @XmlElement(nillable = true)
    protected String fieldName;
    protected Integer fieldOrder;
    @XmlElement(nillable = true)
    protected String fieldShowName;
    @XmlElement(nillable = true)
    protected String fieldShowValue;
    @XmlElement(nillable = true)
    protected String fieldType;
    @XmlElement(nillable = true)
    protected String fieldValue;
    @XmlElement(nillable = true)
    protected String filedHtmlShow;
    protected Boolean mand;
    @XmlElement(nillable = true)
    protected ArrayOfString selectnames;
    @XmlElement(nillable = true)
    protected ArrayOfString selectvalues;
    protected Boolean view;

    /**
     * 获取browserurl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserurl() {
        return browserurl;
    }

    /**
     * 设置browserurl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserurl(String value) {
        this.browserurl = value;
    }

    /**
     * 获取edit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEdit() {
        return edit;
    }

    /**
     * 设置edit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEdit(Boolean value) {
        this.edit = value;
    }

    /**
     * 获取fieldDBType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldDBType() {
        return fieldDBType;
    }

    /**
     * 设置fieldDBType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldDBType(String value) {
        this.fieldDBType = value;
    }

    /**
     * 获取fieldFormName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldFormName() {
        return fieldFormName;
    }

    /**
     * 设置fieldFormName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldFormName(String value) {
        this.fieldFormName = value;
    }

    /**
     * 获取fieldHtmlType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldHtmlType() {
        return fieldHtmlType;
    }

    /**
     * 设置fieldHtmlType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldHtmlType(String value) {
        this.fieldHtmlType = value;
    }

    /**
     * 获取fieldId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldId() {
        return fieldId;
    }

    /**
     * 设置fieldId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldId(String value) {
        this.fieldId = value;
    }

    /**
     * 获取fieldName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置fieldName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldName(String value) {
        this.fieldName = value;
    }

    /**
     * 获取fieldOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFieldOrder() {
        return fieldOrder;
    }

    /**
     * 设置fieldOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFieldOrder(Integer value) {
        this.fieldOrder = value;
    }

    /**
     * 获取fieldShowName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldShowName() {
        return fieldShowName;
    }

    /**
     * 设置fieldShowName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldShowName(String value) {
        this.fieldShowName = value;
    }

    /**
     * 获取fieldShowValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldShowValue() {
        return fieldShowValue;
    }

    /**
     * 设置fieldShowValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldShowValue(String value) {
        this.fieldShowValue = value;
    }

    /**
     * 获取fieldType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * 设置fieldType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldType(String value) {
        this.fieldType = value;
    }

    /**
     * 获取fieldValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * 设置fieldValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldValue(String value) {
        this.fieldValue = value;
    }

    /**
     * 获取filedHtmlShow属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiledHtmlShow() {
        return filedHtmlShow;
    }

    /**
     * 设置filedHtmlShow属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiledHtmlShow(String value) {
        this.filedHtmlShow = value;
    }

    /**
     * 获取mand属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMand() {
        return mand;
    }

    /**
     * 设置mand属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMand(Boolean value) {
        this.mand = value;
    }

    /**
     * 获取selectnames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSelectnames() {
        return selectnames;
    }

    /**
     * 设置selectnames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSelectnames(ArrayOfString value) {
        this.selectnames = value;
    }

    /**
     * 获取selectvalues属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSelectvalues() {
        return selectvalues;
    }

    /**
     * 设置selectvalues属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSelectvalues(ArrayOfString value) {
        this.selectvalues = value;
    }

    /**
     * 获取view属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isView() {
        return view;
    }

    /**
     * 设置view属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setView(Boolean value) {
        this.view = value;
    }

}
