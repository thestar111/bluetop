package com.bluetop.upms.biz.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bluetop.upms.biz.database.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <权限数据Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/14 12:10 下午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 根据用户及项目key查询当前用户拥有的资源
     *
     * @param userId         用户id
     * @param applicationKey 项目key
     * @return
     */
    List<Resource> getResourcesByUserAndAppKey(@Param("userId") Integer userId, @Param("applicationKey") String applicationKey);

    /**
     * 获取当前用户获取的项目列表信息
     *
     * @param userId         用户id
     * @return
     */
    List<Resource> getResourceByUser(@Param("userId") Integer userId, @Param("type") Integer type);

    /**
     * 获取当前用户获取的项目列表信息
     *
     * @param userId         用户id
     * @return
     */
    List<Resource> getAllResourceByUser(@Param("userId") Integer userId);

    /**
     * 获取当前项目所有资源
     *
     * @param applicationKey
     * @return
     */
    List<Resource> getResourcesByAppKey(@Param("applicationKey") String applicationKey);
}