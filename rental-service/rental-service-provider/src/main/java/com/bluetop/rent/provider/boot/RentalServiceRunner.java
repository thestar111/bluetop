/**
 * 文 件 名:  RentalServiceRunner
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:52
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.rent.provider.boot;

import com.bluetop.framework.core.bind.EnableLog;
import com.bluetop.framework.core.bind.EnableRequestTrance;
import com.bluetop.framework.core.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * <服务启动入口>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/21 21:52
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@EnableLog
@EnableRequestTrance
@Import(ApplicationConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.bluetop.rent")
public class RentalServiceRunner {
    public static void main(String[] args) {
        SpringApplication.run(RentalServiceRunner.class, args);
    }
}
