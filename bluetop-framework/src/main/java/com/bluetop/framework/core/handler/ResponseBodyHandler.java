/**
 * 文 件 名:  ResponseBodyHandler
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.handler;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import static com.bluetop.framework.core.cons.Constans.TRANCE_ID;
import static com.bluetop.framework.core.context.RequestHeader.*;

/**
 * <消息统一处理>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 21:28
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@ControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    /** 系统应用名 */
    @Value("${spring.application.name:}")
    private String applicationName;

    /**
     * 是否支持注入
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 响应头拦截
     *
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        serverHttpResponse.getHeaders().add(X_REQUEST_ID.getName(), ThreadContext.get(TRANCE_ID));
        serverHttpResponse.getHeaders().add(X_APPLICATION_CONTEXT.getName(), applicationName);
        serverHttpResponse.getHeaders().add(X_VIA.name(), X_VIA.getName());
        return body;
    }
}
