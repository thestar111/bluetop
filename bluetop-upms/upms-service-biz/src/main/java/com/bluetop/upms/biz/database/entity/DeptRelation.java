package com.bluetop.upms.biz.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * <组织结构关系>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/14 11:56 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@TableName(value = "upms_dept_relation")
public class DeptRelation extends Model<DeptRelation> {

    /**
     * 关系ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 祖先节点
     */
    private Integer ancestor;

    /**
     * 后代节点
     */
    private Integer descendant;
}
