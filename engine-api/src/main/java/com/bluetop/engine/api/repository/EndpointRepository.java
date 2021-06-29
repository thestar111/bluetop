/**
 * 文 件 名:  EndpointRepository
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  9:05
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.repository;

import com.bluetop.engine.api.bean.Endpoint;
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
public interface EndpointRepository {
    /**
     * 添加
     *
     * @param endpoint
     * @return
     */
    int addEndpoint(Endpoint endpoint);

    /**
     * Enable
     *
     * @param eptId
     * @return
     */
    int enableEndpoint(String eptId);

    /**
     * Disable
     *
     * @param eptId
     * @return
     */
    int disableEndpoint(String eptId);

    /**
     *
     * @param id
     * @return
     */
    Endpoint getById(Integer id);

    /**
     * 查询列表
     *
     * @return
     */
    List<Endpoint> listEndpoint(@Param("index") Integer index, @Param("size") Integer size, @Param("status") String status);
}
