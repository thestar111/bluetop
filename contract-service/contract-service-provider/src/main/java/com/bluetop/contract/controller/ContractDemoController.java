package com.bluetop.contract.controller;

import com.bluetop.contract.api.facade.demo.ContractDemoFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <一句话功能描述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 10:20 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Controller
public class ContractDemoController implements ContractDemoFacade {

    @PostMapping(value = "/say")
    public String sayHello(@RequestParam("name") String name) {
        return "hi " + name;
    }
}
