package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 查询当前用户锁拥有当前系统的角色集合
     *
     * @param userId
     * @param applicationKey
     * @return
     */
    List<Role> getRolesByUserAndAppKey(@Param("userId") Integer userId, @Param("applicationKey") String applicationKey);
}