/**
 * 文 件 名:  Result
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  20:57
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.cons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Result<T> implements Serializable {

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
}
