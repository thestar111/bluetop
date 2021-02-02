package com.bluetop.framework.core.configuration;

import com.bluetop.framework.core.log.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <日志拦截打印配置>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 5:46 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Configuration
public class LogPrintConfiguration {

    /**
     * 开启日志拦截
     *
     * @return
     */
    @Bean
    public Log log() {
        return new Log();
    }
}
