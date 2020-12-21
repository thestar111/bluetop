/**
 * 文 件 名:  DemoController
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:09
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.backoffice.provider.controller;

import com.bluetop.backoffice.api.facade.demo.DemoServiceFacade;
import com.bluetop.framework.core.cons.PrintLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <示例API>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/19 22:09
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Configuration
@RestController
public class DemoController implements DemoServiceFacade {

    @Autowired
    @Value("${backoffice.service}")
    private String applicationName;

    /**
     * 示例API
     *
     * @param name
     * @return
     */
    @PostMapping("/say")
    @PrintLog
    public String sayHello(@RequestParam("name") String name) {
        return "Hi " + applicationName;
    }
}
