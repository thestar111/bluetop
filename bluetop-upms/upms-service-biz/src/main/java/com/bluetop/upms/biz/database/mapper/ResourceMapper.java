package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <权限操作Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface ResourceMapper {

    /**
     * 添加权限
     *
     * @param resource
     * @return
     */
    int add(Resource resource);

    /**
     * 修改权限
     *
     * @param resource
     * @return
     */
    int modify(Resource resource);

    /**
     * 根据应用ID查询
     *
     * @param applicationId
     * @return
     */
    List<Resource> queryByApplicationId(@Param("applicationId") Integer applicationId);

    /**
     * 删除权限
     *
     * @param status
     * @param id
     * @return
     */
    int modifyStatus(@Param("status") Integer status, @Param("id") Integer id);

    /**
     * 根据应用ID查询
     *
     * @param id
     * @return
     */
    int queryById(@Param("id") Integer id);
}