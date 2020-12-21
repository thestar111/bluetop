/**
 * 文 件 名:  FinanceServiceRunner
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:07
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.finance.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/21 22:07
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.bluetop.finance")
public class FinanceServiceRunner {

    public static void main(String[] args) {
        SpringApplication.run(FinanceServiceRunner.class, args);
    }
}
