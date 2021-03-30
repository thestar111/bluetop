/**
 * 文 件 名:  EngineApiService
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.boot;

import com.bluetop.engin.api.chain.RequestLogChainFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * <启动入口>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/3/28 22:17
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.bluetop.engin.api")
public class EngineApiService {

    @Value("${spring.application.name:}")
    private String applicationName;

    /**
     * 添加拦截
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean requestTrance() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestLogChainFilter());
        registration.addUrlPatterns(String.format("/%s/api/*", applicationName));
        registration.setName("RequestLogChainFilter");
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }

    public static void main(String[] args) {
        SpringApplication.run(EngineApiService.class, args);
    }
}
