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
import com.bluetop.backoffice.data.entity.Config;
import com.bluetop.backoffice.data.mapper.ConfigMapper;
import com.bluetop.contract.api.facade.demo.ContractDemoFacade;
import com.bluetop.framework.core.annotation.PrintLog;
import com.bluetop.framework.core.vo.R;
import com.bluetop.framework.core.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <示例API>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/19 22:09
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Api(tags = "示例APi")
@RestController
public class DemoController implements DemoServiceFacade {

    @Value("${backoffice.service:}")
    private String applicationName;

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private ContractDemoFacade contractDemoFacade;

    /**
     * 示例API
     *
     * @param name
     * @return
     */
    @PrintLog
    @ApiOperation("示例AIP接口")
    @PostMapping("/say")
    public R<String> sayHello(@RequestParam("name") String name) {
        List<Config> configs = configMapper.getAll();
        return R.ok(JsonUtils.toJson(configs));
    }
}
