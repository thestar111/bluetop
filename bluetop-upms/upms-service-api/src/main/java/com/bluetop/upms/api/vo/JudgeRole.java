/**
 * 文 件 名:  JudgeRole
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:31
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <判断角色信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 22:31
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class JudgeRole implements Serializable {
    private String judgeRoleKey;
    private boolean isOwn;
}
