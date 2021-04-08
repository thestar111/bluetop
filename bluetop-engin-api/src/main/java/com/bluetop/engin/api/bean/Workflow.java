/**
 * 文 件 名:  Workflow
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  14:07
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * <流程信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/4 14:07
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class Workflow implements Serializable {

    /** 工作流ID */
    private String workflowId;

    /** 工作流名称 */
    private String workflowName;
}
