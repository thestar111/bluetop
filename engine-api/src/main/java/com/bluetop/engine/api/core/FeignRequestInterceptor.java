/**
 * 文 件 名:  FeignRequestInterceptor
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  17:22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.core;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/29 17:22
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    /**
     *
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HeaderContext ctx = HeaderContext.getHeaderContext();
        Map<String, String> header = ctx.getHeader();
        header.forEach((k, v) -> {
            requestTemplate.header(k, v);
        });
    }
}
