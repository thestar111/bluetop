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
import com.bluetop.contract.api.facade.demo.ContractDemoFacade;
import com.bluetop.framework.core.annotation.PrintLog;
import com.bluetop.framework.core.cons.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RestController
public class DemoController implements DemoServiceFacade {

    @Value("${backoffice.service}")
    private String applicationName;

    @Autowired
    private ContractDemoFacade contractDemoFacade;

    /**
     * 示例API
     *
     * @param name
     * @return
     */
    @PrintLog
    @PostMapping("/say")
    public Result<String> sayHello(@RequestParam("name") String name) {
        //contractDemoFacade.sayHello(name);
        Result<String> result = new Result<>();
        result.setData("Hi " + applicationName);
        result.setData("SUCCESS");
        return result;
    }
}
