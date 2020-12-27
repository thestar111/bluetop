package com.bluetop.upms.biz.database.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer parentId;
    private Integer applicationId;
    private String name;
    /**
     * 资源编码
     */
    private String code;
    private String url;
    private String description;
    /**
     * 0:系统, 1:菜单, 2:Api
     */
    private Integer type;
    private String icon;
    private Integer order;
    /**
     * 0:禁用 1:启用 -3:垃圾桶 -4:删除
     */
    private Integer status;
    private Date createTime;
    private Integer createUserId;
    private Date updateTime;
    private Integer updateUserId;
}
