package com.bluetop.upms.biz.provider.dept;

import com.bluetop.upms.api.dept.DeptApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话功能描述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:19 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@RestController
public class DeptController implements DeptApi {

    @Override
    public void addDept() {
        log.info("添加部门信息");
    }
}
