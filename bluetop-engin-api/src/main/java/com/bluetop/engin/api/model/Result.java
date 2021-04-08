/**
 * 文 件 名:  Result
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  15:43
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <通用结果>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/5 15:43
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@ApiModel(value="返回结果对象")
public class Result<T> implements Serializable {

    /** 错误码 */
    @ApiModelProperty(value = "响应结果码",required = true)
    private int code;

    /** 错误描述 */
    @ApiModelProperty(value = "响应描述",required = true)
    private String msg;

    /** 数据 */
    @ApiModelProperty(value = "响应结果数据对象")
    private T data;
}
