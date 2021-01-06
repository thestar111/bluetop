package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.Application;
import com.bluetop.upms.biz.database.entity.UserResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <用户权限Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface UserResourceMapper {
    /**
     * 添加用户权限信息
     *
     * @param userResource
     * @return
     */
    int add(UserResource userResource);

    /**
     * 查询用户权限信息
     *
     * @param userId
     * @return
     */
    List<UserResource> listAll(Integer userId);

    /**
     * 根据用户ID删除权限信息
     *
     * @param userId
     * @return
     */
    int deleteByUser(Integer userId);
}