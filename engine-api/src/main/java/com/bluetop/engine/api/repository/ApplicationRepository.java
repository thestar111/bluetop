/**
 * 文 件 名:  ApplicationRepository
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  9:05
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.repository;

import com.bluetop.engine.api.bean.Application;
import com.bluetop.engine.api.constant.StatusEnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 9:05
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface ApplicationRepository {

    /**
     * 添加
     * @param application
     * @return
     */
    int addApplication(Application application);

    /**
     * Enable
     * @param applicationId
     * @return
     */
    int enableApplication(String applicationId);

    /**
     * Disable
     * @param applicationId
     * @return
     */
    int disableApplication(String applicationId);

    /**
     *
     * @param id
     * @return
     */
    Application getById(Integer id);

    /**
     * 查询列表
     * @return
     */
    List<Application> listApplication(@Param("index") Integer index, @Param("size") Integer size, @Param("status") String status);
}
