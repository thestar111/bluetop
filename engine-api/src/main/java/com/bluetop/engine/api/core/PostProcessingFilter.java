/**
 * 文 件 名:  PostProcessingFilter
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  18:21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/29 18:21
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Configuration
@Order(-1)
public class PostProcessingFilter implements WebFilter {

    /**
     * 过滤器
     * @param serverWebExchange
     * @param webFilterChain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        ServerHttpRequest request =  serverWebExchange.getRequest();
        //获取请求http头xttblog_token值
        HttpHeaders headers = request.getHeaders();
        headers.entrySet().forEach(k -> {
            System.out.println(k.getKey() + "===============" + k.getValue());
        });
        /*过滤器链的概念都是类似的，调用过滤器链的filter方法将请求转到下一个filter，如果该filter是最后一  个filter,那就转到
        该请求对应的handler,也就是controller方法或函数式endpoint */
        return webFilterChain.filter(serverWebExchange);
    }
}
