/**
 * 文 件 名:  RequestContext
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  20:41
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.context;

import lombok.Data;

/**
 * <请求上下文>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 20:41
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class RequestContext {

    private static final ThreadLocal<RequestContext> contextTL = new ThreadLocal<>();

    /** 客户端传过来的token */
    private String accessToken;

    /** Token对象 */
    private String token;

    /** 请求IP */
    private String ip, remoteAddr;

    /** 请求ID */
    private String reqId;

    /** 请求来源 */
    private String reqSource;

    /**
     * 获取请求上下文
     *
     * @return
     */
    public static RequestContext get() {
        RequestContext ctx = contextTL.get();
        return ctx == null ? new RequestContext() : ctx;
    }

    /**
     * 设置上下文
     *
     * @param ctx
     */
    public static void set(RequestContext ctx) {
        if (ctx == null) {
            contextTL.remove();
        } else {
            contextTL.set(ctx);
        }
    }

    /**
     * 清空上下文信息
     */
    public static void clear() {
        if (contextTL != null) {
            contextTL.remove();
        }
    }
}
