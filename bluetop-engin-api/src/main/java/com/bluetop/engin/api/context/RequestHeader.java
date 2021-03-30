/**
 * 文 件 名:  RequestHeader
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.context;

import lombok.Getter;

/**
 * <基础请求头信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 21:28
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Getter
public enum RequestHeader {
    X_REQUEST_ID("X-Request-ID"),
    X_REQUEST_FROM("X-Request-From"),
    X_CUSTOMER_IP("X-Customer-Ip"),
    X_APPLICATION_CONTEXT("X-Application-Context"),
    X_VIA("lantuo-via");

    /**
     * 请求头名称
     */
    private String name;

    RequestHeader(String name) {
        this.name = name;
    }
}
