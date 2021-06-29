/**
 * 文 件 名:  R
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  10:53
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * <返回结果>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 10:53
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class R<T> implements Serializable {

    /** 返回码 */
    private int code = 0;

    /** 描述 */
    private String desc = "SUCCESS";

    /** 返回数据 */
    private T data;

    /**
     *
     * @return
     */
    public static R failed() {
        R r = new R();
        r.setCode(-1);
        r.setDesc("FAILED");
        return r;
    }

    /**
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R success(T data) {
        R r = new R();
        r.setData(data);
        return r;
    }
}
