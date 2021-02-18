package com.bluetop.token.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <一句话功能描述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/26 12:21 下午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class TokenVO implements Serializable {

    /** 访问Token */
    private String access_token;

    /**  */
    private boolean active;

    /** 过期时间 */
    private long expires_in;

    /** 刷新token */
    private String refresh_token;

    /** 范围 */
    private String scope;

    /** Token类型 */
    private String token_type;
}
