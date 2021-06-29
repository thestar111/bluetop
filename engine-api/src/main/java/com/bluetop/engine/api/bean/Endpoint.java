/**
 * 文 件 名:  Application
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  9:56
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.bean;

import com.bluetop.engine.api.constant.MethodEnum;
import com.bluetop.engine.api.constant.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.StringJoiner;

/**
 * <接口信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 9:56
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class Endpoint implements Serializable {

    /** 接口ID */
    private String eptId;

    /** 名称 */
    private String name;

    /** 应用ID */
    private Integer applicationId;

    /** 应用名称 */
    private String applicationName;

    /** 资源地址 */
    private String uri;

    /** 状态 */
    private StatusEnum status;

    /** 请求方式 */
    private MethodEnum method;

    /** 请求头地址 */
    private Map<String, String> header;

    /** 备注 */
    private String remark;

    /**
     * 设置URL
     * @param url
     */
    public void setUrl(String url) {
        this.uri = new StringJoiner("").add(url).add(getUri()).toString();
    }
}
