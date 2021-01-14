package com.bluetop.upms.biz.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <一句话功能描述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/14 11:47 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@TableName(value = "upms_menu")
public class Menu extends Model<Menu> {

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 父菜单ID
     */
    private Integer parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 前端URL
     */
    private String path;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private String type;

    /**
     * 路由缓冲
     */
    private String keepAlive;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 0--正常 1--删除
     */
    @TableLogic
    private String delFlag;
}
