package com.bluetop.upms.biz.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <用户信息实体>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@TableName("upms_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String company;
    private String email;
    private String secret;
    /**
     * 0：注销，1:激活 -4:删除
     */
    private Integer status;
    private Date createTime;
    private String createUserId;
    private Date updateTime;
    private String updateUserId;
}
