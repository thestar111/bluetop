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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="流程日志信息")
public class WorkflowLog implements Serializable {

    /** 业务ID */
    @ApiModelProperty(value = "流程日志ID")
    private Integer id;

    /** 请求ID */
    @ApiModelProperty(value = "请求ID")
    private String requestId;

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /** 工作流ID */
    @ApiModelProperty(value = "工作流ID")
    private String workflowId;

    /** 工作流名称 */
    @ApiModelProperty(value = "工作流名称")
    private String workflowName;

    /** 重试次数 */
    @ApiModelProperty(value = "重试次数")
    private int retryTime;

    /** 重试最大次数 */
    @ApiModelProperty(value = "重试最大次数")
    private int retryMaxTime;

    /** NEW, REJECT, COMPLETE */
    @ApiModelProperty(value = "流程状态：NEW, REJECT, COMPLETE")
    private String status;

    /** 应用机器号 */
    @ApiModelProperty(value = "应用机器号")
    private String machine;

}
