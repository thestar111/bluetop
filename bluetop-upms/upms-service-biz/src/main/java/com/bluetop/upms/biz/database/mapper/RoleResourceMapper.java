package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.RoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <角色权限Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface RoleResourceMapper {

    /**
     * 添加角色权限
     *
     * @param roleResource
     * @return
     */
    int add(RoleResource roleResource);

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据角色ID删除
     *
     * @param roleId
     * @return
     */
    int deleteByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据角色ID查询
     *
     * @param roleId
     * @return
     */
    List<RoleResource> queryByRoleId(@Param("roleId") Integer roleId);
}