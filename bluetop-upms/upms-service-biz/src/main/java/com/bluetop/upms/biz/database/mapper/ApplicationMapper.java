package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <项目数据操作Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface ApplicationMapper {

    /**
     * 添加应用信息
     *
     * @param application
     * @return
     */
    int add(Application application);

    /**
     * 修改应用信息
     *
     * @param application
     * @return
     */
    int modify(Application application);

    /**
     * 查询应用列表
     *
     * @param start
     * @param size
     * @return
     */
    List<Application> listAll(@Param("start") Integer start, @Param("size") Integer size);

    /**
     * 根据应用Key查询
     *
     * @param applicationKey
     * @return
     */
    Application getApplicationByAppkey(String applicationKey);

}