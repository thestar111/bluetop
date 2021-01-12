package com.bluetop.upms.biz.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <用户权限实体>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@TableName("upms_user_resource")
public class UserResource extends Model<UserResource> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 权限ID
     */
    private Integer resourceId;
    private Date createTime;
    private Integer createUserId;
    private Date updateTime;
    private Integer updateUserId;
}
