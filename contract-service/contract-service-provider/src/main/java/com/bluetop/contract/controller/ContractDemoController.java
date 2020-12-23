package com.bluetop.contract.controller;

import com.bluetop.contract.api.facade.demo.ContractDemoFacade;
import com.bluetop.framework.core.annotation.PrintLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <自定义示例API>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 10:20 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@RestController
public class ContractDemoController implements ContractDemoFacade {

    @PrintLog
    @PostMapping(value = "/say")
    public String sayHello(@RequestParam("name") String name) {
        return "hi " + name;
    }
}
