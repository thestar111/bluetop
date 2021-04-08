/**
 * 文 件 名:  WorkflowStatus
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  17:31
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.cons;

import lombok.Getter;

/**
 * <流程状态>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/6 17:31
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Getter
public enum WorkflowStatus {

    /** 已审批 */
    COMPLETE("归档"),

    /** 已拒绝 */
    REJECT("制单人");

    private String status;

    WorkflowStatus(String status) {
        this.status = status;
    }
}
