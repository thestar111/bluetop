package com.bluetop.upms.biz.core.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * <鉴权Token>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:33 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public class Token implements AuthenticationToken {

    /**
     * 密钥
     */
    private String token;

    public Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
