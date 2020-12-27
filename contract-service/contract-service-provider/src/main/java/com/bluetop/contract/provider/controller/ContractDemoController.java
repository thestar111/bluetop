package com.bluetop.contract.provider.controller;

import com.bluetop.contract.api.facade.demo.ContractDemoFacade;
import com.bluetop.framework.core.annotation.PrintLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "示例API接口")
@RestController
public class ContractDemoController implements ContractDemoFacade {

    /**
     * 合同示例接口
     *
     * @param name
     * @return
     */
    @ApiOperation("合同示例接口")
    @PrintLog
    @PostMapping(value = "/say")
    public String sayHello(@RequestParam("name") String name) {
        return "hi " + name;
    }
}
