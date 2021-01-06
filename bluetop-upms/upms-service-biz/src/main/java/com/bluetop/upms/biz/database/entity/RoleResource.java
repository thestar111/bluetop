package com.bluetop.upms.biz.database.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <权限角色实体>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer roleId;
    private Integer resourceId;
    private Date createTime;
    private Integer createUserId;
    private Date updateTime;
    private Integer updateUserId;
}
