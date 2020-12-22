/**
 * 文 件 名:  DemoFacade
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:49
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.backoffice.api.facade.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <示例服务>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/19 21:49
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@FeignClient(name = "${backoffice.service:backoffice-service}", url = "{url.backoffice-service:}")
public interface DemoServiceFacade {

    /**
     * 示例API
     *
     * @param name
     * @return
     */
    @PostMapping(value = "/say")
    String sayHello(@RequestParam("name") String name);
}
