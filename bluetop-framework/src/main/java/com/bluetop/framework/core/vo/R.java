/**
 * 文 件 名:  Result
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  20:57
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.vo;

import com.bluetop.framework.core.cons.Error;
import com.bluetop.framework.core.cons.IErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * <基础数据返回实体>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 20:57
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> implements Serializable {

    /** 返回码 */
    private int code;

    /** 描述信息 */
    private String msg;

    /** 返回数据信息 */
    private T data;

    /** 错误信息 */
    private Error error;

    /** 是否成功 */
    private boolean success = true;

    /**
     * 成功
     *
     * @param <T>
     * @return
     */
    public static <T> R<T> ok() {
        return restResult(null, IErrorCodeEnum.Business_success, null);
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R<T> ok(T data) {
        return restResult(data, IErrorCodeEnum.Business_success, null);
    }

    /**
     * 成功
     *
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, IErrorCodeEnum.Business_success, msg);
    }

    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> R<T> failed() {
        return restResult(null, IErrorCodeEnum.Business_not_success, null);
    }

    /**
     * 失败
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> R<T> failed(String msg) {
        return restResult(null, IErrorCodeEnum.Business_not_success, msg);
    }

    /**
     * 失败
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R<T> failed(T data) {
        return restResult(data, IErrorCodeEnum.Business_not_success, null);
    }

    /**
     * 失败
     *
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, IErrorCodeEnum.Business_not_success, msg);
    }

    /**
     * 设置结果信息
     *
     * @param data
     * @param codeEnum
     * @param <T>
     * @return
     */
    private static <T> R<T> restResult(T data, IErrorCodeEnum codeEnum, String msg) {
        R<T> result = new R<>();
        result.setData(data);
        result.setCode(codeEnum.getErrorCode());
        result.setMsg(StringUtils.isNotEmpty(msg) ? msg : codeEnum.getErrorMsg());
        return result;
    }
}
