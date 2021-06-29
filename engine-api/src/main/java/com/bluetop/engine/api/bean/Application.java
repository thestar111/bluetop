/**
 * 文 件 名:  Application
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  9:56
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.bean;

import com.bluetop.engine.api.constant.EnvEnum;
import com.bluetop.engine.api.constant.StatusEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * <应用实体>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 9:56
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class Application implements Serializable {

    /** 应用ID */
    private Integer applicationId;

    /** 应用名称 */
    private String applicationName;

    /** 应用状态 */
    private String status;

    /** 应用地址 */
    private String url;

    /** 环境 @linkplain{EnvStatus} */
    private String env;

    /** 备注 */
    private String remark;
}
