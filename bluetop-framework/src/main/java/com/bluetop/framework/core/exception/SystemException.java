/**
 * 文 件 名:  BusinessException
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  20:38
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.exception;

import com.bluetop.framework.core.cons.IErrorCodeEnum;
import lombok.Data;

/**
 * <业务异常>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 20:38
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class SystemException extends RuntimeException{
    /**
     * 错误码
     */
    private IErrorCodeEnum errorCodeEnum;

    /**
     * 错误码
     */
    private int errorCode;

    /**
     * 错误描述
     */
    private String errorMsg;

    /**
     * 构造方法
     *
     * @param errorCodeEnum
     */
    public SystemException(IErrorCodeEnum errorCodeEnum)
    {
        this.errorCodeEnum = errorCodeEnum;
    }

    /**
     * 构造方法
     *
     * @param errorCode
     * @param errorMsg
     */
    public SystemException(int errorCode, String errorMsg)
    {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 获取错误码描述
     *
     * @return
     */
    public IErrorCodeEnum getErrorCodeEnum()
    {
        return errorCodeEnum;
    }

    /**
     * 设置返回码
     *
     * @param errorCodeEnum
     */
    public void setErrorCodeEnum(IErrorCodeEnum errorCodeEnum)
    {
        this.errorCodeEnum = errorCodeEnum;
    }
}
