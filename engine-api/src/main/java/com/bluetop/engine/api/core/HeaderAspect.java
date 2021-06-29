/**
 * 文 件 名:  HeaderAspect
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  17:54
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.core;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/29 17:54
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Aspect
@Component
public class HeaderAspect {

    @Pointcut("@annotation(com.bluetop.engine.api.core.Header)")
    public void annotationPoinCut(){}

    /**
     *
     * @param joinPoint
     */
    @After("annotationPoinCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Header header = method.getAnnotation(Header.class);
        method.getAnnotatedParameterTypes();
        HeaderContext.clear();
    }

    /**
     *
     * @param joinPoint
     */
    @Before("annotationPoinCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截," + method.getName());
    }
}
