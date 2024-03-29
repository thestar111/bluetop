package com.bluetop.framework.core.configuration;

import com.bluetop.framework.core.executor.GuavaCacheListeningExecutor;
import com.bluetop.framework.core.handler.GlobalExceptionHandler;
import com.bluetop.framework.core.interceptor.RequestHeaderInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

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
public class ApplicationConfiguration implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String instanceId;

    private volatile Connector connector;

    /** 应用程序等待时间 */
    private final int WAIT_TIME = 10;

    /**
     * 配置拦截路径，无需在对应点Controller定义URI的时候都加上应用名称/api
     *
     * @param dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        log.info("[ApplicationConfiguration] bootstrap application : {} instanceid : {}", applicationName, instanceId);
        return new ServletRegistrationBean(dispatcherServlet, String.format("/%s/api/*", applicationName),
                "/actuator/prometheus", "/actuator/health", "/actuator/shutdown", "/v2/api-docs", "/*");
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

    /**
     * 监控信息收集
     *
     * @return
     */
    @Bean
    public MeterRegistryCustomizer<?> meterRegistryCustomizer() {
        return meterRegistry -> meterRegistry.config().commonTags("application", applicationName, "instanceId", instanceId);
    }

    /**
     * Guava缓存监听执行器
     *
     * @return
     */
    @Bean
    public GuavaCacheListeningExecutor executor() {
        return new GuavaCacheListeningExecutor();
    }


    @Override
    public void customize(Connector connector) {
        this.connector = connector;
    }

    /**
     * 监听应用程序上下文关闭事件
     *
     * @param contextClosedEvent
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        connector.pause();
        Executor executor = connector.getProtocolHandler().getExecutor();
        if (executor instanceof ThreadPoolExecutor) {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                threadPoolExecutor.shutdown();
                if (!threadPoolExecutor.awaitTermination(WAIT_TIME, TimeUnit.SECONDS)) {
                    log.error("[{}] shutdown failed. please force shutdown it.", applicationName);
                }
            } catch (Exception e) {
                log.error("[{}] shutdown failed. error : {}", applicationName, ExceptionUtils.getRootCauseMessage(e));
                Thread.currentThread().interrupt();
            }
        }
    }
}
