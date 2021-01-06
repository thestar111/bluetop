package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    /**
     * 添加用户角色
     *
     * @param userRoles
     * @return
     */
    int add(List<UserRole> userRoles);

    /**
     * 根据用户ID获取用户角色信息
     *
     * @param userId
     * @return
     */
    List<UserRole> getRolesByUserId(@Param("userId") Integer userId);

    /**
     * 删除用户角色信息
     *
     * @param userId
     * @return
     */
    int deleteByUserId(@Param("userId") Integer userId);

}