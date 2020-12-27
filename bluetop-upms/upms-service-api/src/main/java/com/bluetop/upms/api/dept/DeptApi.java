package com.bluetop.upms.api.dept;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <一句话功能描述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:17 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@RequestMapping("/dept")
public interface DeptApi {

    /**
     * 添加部门
     */
    @PostMapping(value = "/add")
    void addDept();
}
