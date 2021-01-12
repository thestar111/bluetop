package com.bluetop.upms.biz.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <应用信息表>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@TableName("upms_application")
public class Application extends Model<Application> {

    private static final long serialVersionUID = 1L;
    /**
     * 业务ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 应用名称
     */
    private String applicationName;
    /**
     * 应用Key
     */
    private String applicationKey;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建用户ID
     */
    private Integer createUserId;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新用户ID
     */
    private Integer updateUserId;

}
