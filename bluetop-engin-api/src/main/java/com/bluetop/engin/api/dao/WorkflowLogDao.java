/**
 * 文 件 名:  WorkflowLogDao
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  4:44
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.dao;

import com.bluetop.engin.api.bean.WorkflowLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/6 4:44
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface WorkflowLogDao {

    /**
     * 添加流程日志
     *
     * @param workflowLog
     * @return
     */
    int addLog(WorkflowLog workflowLog);

    /**
     * 获取流程列表信息
     *
     * @return
     */
    List<WorkflowLog> list();

    /**
     * 分页获取流程信息
     *
     * @param id
     * @return
     */
    List<WorkflowLog> listById(@Param("id") int id);

    /**
     * 修改流程信息
     *
     * @param requestId
     * @return
     */
    int modifyWorkflow(@Param("requestId") String requestId, @Param("status") String status);

    /**
     * 获取流程信息
     *
     * @param requestId
     * @param userId
     * @return
     */
    WorkflowLog getWorkflow(@Param("requestId") Integer requestId, @Param("userId") Integer userId);
}
