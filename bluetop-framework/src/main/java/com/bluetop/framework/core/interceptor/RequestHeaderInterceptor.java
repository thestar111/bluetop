package com.bluetop.framework.core.interceptor;

import com.bluetop.framework.core.context.RequestContext;
import com.bluetop.framework.core.context.RequestHeader;
import com.bluetop.framework.core.utils.GUID;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <请求头封装信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 9:56 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Configuration
public class RequestHeaderInterceptor implements RequestInterceptor {

    @Value("${spring.application.name}")
    private String applicationName;

    public RequestHeaderInterceptor() {

    }

    /**
     * 添加请求头
     *
     * @param template
     */
    @Override
    public void apply(RequestTemplate template) {
        template.header(RequestHeader.X_REQUEST_FROM.getName(), new String[]{applicationName});
        RequestContext request = RequestContext.get();
        if (null != request) {
            template.header(RequestHeader.X_REQUEST_ID.getName(), new String[]{request.getReqId()});
            template.header(RequestHeader.X_CUSTOMER_IP.getName(), new String[]{request.getIp()});
        } else {
            template.header(RequestHeader.X_REQUEST_ID.getName(), new String[]{GUID.get()});
        }
    }
}
