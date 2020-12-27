/**
 * 文 件 名:  RoleVO
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 22:20
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class RoleVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    private String roleKey;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 状态，0：禁用 1：启用 -4:删除
     */
    private Integer status;
    /**
     * 项目key
     */
    private String applicationKey;
}
