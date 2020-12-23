package com.bluetop.framework.core.configuration;

import com.bluetop.framework.core.chain.RequestLogChainFilter;
import com.bluetop.framework.core.handler.ResponseBodyHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <请求日志追踪配置>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 9:04 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Configuration
public class RequestTranceConfiguration {

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

    /**
     * 返回消息统一处理
     *
     * @return
     */
    @Bean
    public ResponseBodyHandler responseBodyHandler() {
        return new ResponseBodyHandler();
    }
}
