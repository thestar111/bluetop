package com.bluetop.framework.core.bind;

import com.bluetop.framework.core.configuration.LogPrintConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <是否启用拦截打印日志信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 5:43 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(LogPrintConfiguration.class)
public @interface EnableLog {
}
