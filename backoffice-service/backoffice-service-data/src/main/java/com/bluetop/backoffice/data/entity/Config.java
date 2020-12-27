/**
 * 文 件 名:  Config
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:39
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.backoffice.data.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <系统配置>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/25 22:39
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class Config implements Serializable {

    /**
     * 配置Key
     */
    private String variable;

    /**
     * 配置值
     */
    private String value;
}
