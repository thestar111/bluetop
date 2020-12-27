package com.bluetop.upms.biz.core;

import com.bluetop.framework.core.cons.IErrorCodeEnum;
import com.bluetop.framework.core.exception.SystemException;
import lombok.Data;

/**
 * <授权异常>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class AuthException extends SystemException {

    /**
     * 构造方法
     *
     * @param errorCodeEnum
     */
    public AuthException(IErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }

    /**
     * 构造方法
     *
     * @param errorCode
     * @param errorMsg
     */
    public AuthException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    /**
     * 构造方法
     *
     * @param errorCode
     * @param errorMsg
     */
    public AuthException(String errorMsg, int errorCode) {
        super(errorCode, errorMsg);
    }
}
