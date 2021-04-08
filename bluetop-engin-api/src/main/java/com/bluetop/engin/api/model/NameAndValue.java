/**
 * 文 件 名:  NameAndValue
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  23:29
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * <自定义键值对>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/4 23:29
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@ApiModel(value="表单对象")
public class NameAndValue implements Serializable {

    /** 属性名称 */
    @ApiModelProperty(value = "属性名称")
    private String name;

    /** 属性值 */
    @ApiModelProperty(value = "属性值")
    private String value;

    /** 是否文件 */
    @JsonProperty("isFile")
    @ApiModelProperty(value = "是否文件")
    private boolean isFile = false;

    /** 文件名 */
    @ApiModelProperty(value = "文件名")
    private String fileName = StringUtils.EMPTY;

    public NameAndValue(){}

    /**
     * 键值对
     *
     * @param name
     * @param value
     */
    public NameAndValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 键值对
     *
     * @param name
     * @param value
     */
    public NameAndValue(String name, String value, String fileName) {
        this.name = name;
        this.value = value;
        this.fileName = fileName;
        this.isFile = Boolean.TRUE;
    }
}
