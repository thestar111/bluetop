/**
 * 文 件 名:  Log
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:36
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.log;

import com.bluetop.framework.core.cons.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 21:36
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Aspect
@Component
public class Log {
    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.bluetop.framework.core.cons.PrintLog)")
    public void point() {
    }

    /**
     * 业务执行
     *
     * @param joinPoint
     */
    @Before("point()")
    public void execute(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("请求 URL: {}", request.getRequestURL());
        log.info("请求方法 HTTP_METHOD: {} ", request.getMethod());
        log.info("请求 IP: {}", request.getRemoteAddr());
        log.info("请求类 CLASS_METHOD: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求参数 ARGS: {}", Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 后置通知
     */
    @AfterReturning(returning = "result", pointcut = "point()")
    public void logResultVOInfo(Result result) {
        log.info("请求响应吗 ：【{}】 \t	响应结果 ：【{}】", result.getCode(), result);
    }
}
