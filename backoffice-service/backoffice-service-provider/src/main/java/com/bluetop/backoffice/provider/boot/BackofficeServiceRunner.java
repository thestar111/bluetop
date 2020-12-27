/**
 * 文 件 名:  BackofficeRunner
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:52
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.backoffice.provider.boot;

import com.bluetop.framework.core.bind.EnableLog;
import com.bluetop.framework.core.bind.EnableRequestTrance;
import com.bluetop.framework.core.configuration.ApplicationConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * <启动入口>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/19 21:52
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@EnableLog
@EnableRequestTrance
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.bluetop.backoffice")
@Import(ApplicationConfiguration.class)
@EnableFeignClients(basePackages = {"com.bluetop.contract.api.facade.demo"})
@MapperScan(basePackages = {"com.bluetop.backoffice.data.mapper"})
public class BackofficeServiceRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackofficeServiceRunner.class, args);
    }
}
