package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <用户Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface UserMapper {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    int modify(User user);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int delete(@Param("userId") Integer userId);

    /**
     * 根据用户Id查询
     *
     * @param userId
     * @return
     */
    User queryById(@Param("userId") Integer userId);

    /**
     * 根据用户名称查询
     *
     * @param name
     * @return
     */
    User getUserByUserName(@Param("name") String name);
}