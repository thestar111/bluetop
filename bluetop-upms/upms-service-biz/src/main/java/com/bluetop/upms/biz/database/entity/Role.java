package com.bluetop.upms.biz.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

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
@TableName("upms_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /** 角色Key */
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
     * 应用项目key
     */
    private String applicationKey;
    private LocalDateTime createTime;
    private Integer createUserId;
    private LocalDateTime updateTime;
    private Integer updateUserId;
}
