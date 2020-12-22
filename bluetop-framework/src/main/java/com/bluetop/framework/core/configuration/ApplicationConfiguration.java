package com.bluetop.framework.core.configuration;

import com.bluetop.framework.core.handler.GlobalExceptionHandler;
import com.bluetop.framework.core.interceptor.RequestHeaderInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * <应用配置>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 9:19 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
public class ApplicationConfiguration {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String instanceId;

    /**
     * 配置拦截路径，无需在对应点Controller定义URI的时候都加上应用名称/api
     *
     * @param dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        log.info("[ApplicationConfiguration] bootstrap application : {} instanceid : {}", applicationName, instanceId);
        return new ServletRegistrationBean(dispatcherServlet, String.format("/%s/api/*", applicationName), "/prometheus", "/health");
    }

    /**
     * 全局异常统一处理
     *
     * @return
     */
    @Bean
    public GlobalExceptionHandler exceptionHandler() {
        return new GlobalExceptionHandler();
    }

    /**
     * 请求头拦截
     *
     * @return
     */
    @Bean
    public RequestHeaderInterceptor requestHeaderInterceptor() {
        return new RequestHeaderInterceptor();
    }
}
