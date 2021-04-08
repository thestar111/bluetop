/**
 * 文 件 名:  CreateWorkflowRequest
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  20:57
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.param;

import com.bluetop.engin.api.model.NameAndValue;
import com.bluetop.engin.api.model.TableDetailInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <创建流程请求对象>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/2 20:57
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@ApiModel(value="创建流程对象")
public class CreateWorkflowRequest implements Serializable {

    /** 请求流程ID */
    @ApiModelProperty(value = "流程ID",required = true)
    private String workflowId;

    /** 用户ID */
    @ApiModelProperty(value = "用户ID",required = true)
    private String userId;

    /** 流程级别 */
    @ApiModelProperty(value = "流程级别")
    private String requestLevel = "0";

    /** 流程主表信息 */
    @ApiModelProperty(value = "流程主表单信息")
    private List<NameAndValue> workflowMainTables;

    /** 流程详细表信息 */
    @ApiModelProperty(value = "流程明细表单信息")
    private List<TableDetailInfo> workflowDetailTables;
}
