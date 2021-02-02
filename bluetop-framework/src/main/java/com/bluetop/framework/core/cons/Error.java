package com.bluetop.framework.core.cons;

import lombok.Data;

import java.io.Serializable;

/**
 * <异常信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/23 6:15 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class Error implements Serializable {

    /** 请求ID */
    private String reqId;

    /** 请求路径 */
    private String path;

    /** 请求IP */
    private String ip;

    /** 服务响应状态码 */
    private int state;

    /** 具体信息 */
    private String info;
}
