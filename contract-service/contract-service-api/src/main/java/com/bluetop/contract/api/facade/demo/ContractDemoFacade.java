package com.bluetop.contract.api.facade.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <一句话功能描述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 10:18 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@FeignClient(name = "${contract.service:contract-service}", url = "${url.contract-service:}")
public interface ContractDemoFacade {

    /**
     * 示例API
     *
     * @param name
     * @return
     */
    @PostMapping(value = "/contract-service/api/say")
    String sayHello(@RequestParam("name") String name);
}
