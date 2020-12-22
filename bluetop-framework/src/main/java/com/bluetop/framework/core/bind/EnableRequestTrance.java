package com.bluetop.framework.core.bind;

import com.bluetop.framework.core.configuration.RequestTranceConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <请求日志链配置>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 9:03 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RequestTranceConfiguration.class)
public @interface EnableRequestTrance {
}
