/**
 * 文 件 名:  ApiGateway
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.gw.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/26 21:20
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayServiceRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServiceRunner.class, args);
    }
}
