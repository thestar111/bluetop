/**
 * 文 件 名:  WorkflowLogService
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  4:58
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.service;

import com.bluetop.engin.api.bean.WorkflowLog;
import com.bluetop.engin.api.dao.WorkflowLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/6 4:58
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Service
public class WorkflowLogService {

    @Autowired
    private WorkflowLogDao workflowLogDao;

    /**
     *
     * @return
     */
    public List<WorkflowLog> list() {
        return workflowLogDao.list();
    }
}
