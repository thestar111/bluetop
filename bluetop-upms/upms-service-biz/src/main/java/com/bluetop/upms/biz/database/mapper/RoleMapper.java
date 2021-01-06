package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <角色Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface RoleMapper {

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    int add(Role role);

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    int modify(Role role);

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    int delete(@Param("roleId") Integer roleId);

    /**
     * 根据角色ID查询
     *
     * @param roleId
     * @return
     */
    Role queryById(@Param("roleId") Integer roleId);

    /**
     * 根据应用Key查询
     *
     * @param appKey
     * @return
     */
    List<Role> getRolesByAppKey(@Param("appKey") String appKey);

    /**
     * 查询当前用户锁拥有当前系统的角色集合
     *
     * @param roleIds
     * @return
     */
    List<Role> getRolesByIds(@Param("roleIds") List<Integer> roleIds);
}