package com.bluetop.framework.core.configuration;

import com.bluetop.framework.core.chain.RequestLogChainFilter;
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

    @Bean
    public FilterRegistrationBean requestTrance() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestLogChainFilter());
        registration.addUrlPatterns("/api/*");
        registration.setName("RequestLogChainFilter");
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }
}
