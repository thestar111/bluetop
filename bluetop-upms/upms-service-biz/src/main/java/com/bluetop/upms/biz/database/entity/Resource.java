package com.bluetop.upms.biz.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <权限信息实体>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@TableName("upms_resource")
public class Resource extends Model<Resource> {

    private static final long serialVersionUID = 1L;

    /**
     * 业务主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父级ID
     */
    private Integer parentId;

    /**
     * 应用ID
     */
    private Integer applicationId;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 资源编码
     */
    private String code;

    /**
     * URL链接
     */
    private String url;

    /**
     * 描述
     */
    private String description;

    /**
     * 0:系统, 1:菜单, 2:Api(按钮)
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 0:禁用 1:启用 -3:垃圾桶 -4:删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建用户ID
     */
    private Integer createUserId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新用户ID
     */
    private Integer updateUserId;
}
