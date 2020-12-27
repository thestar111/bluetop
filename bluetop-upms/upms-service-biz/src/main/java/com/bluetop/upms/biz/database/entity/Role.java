package com.bluetop.upms.biz.database.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <角色实体>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class Role implements Serializable {

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
    private Date createTime;
    private Integer createUserId;
    private Date updateTime;
    private Integer updateUserId;
}
