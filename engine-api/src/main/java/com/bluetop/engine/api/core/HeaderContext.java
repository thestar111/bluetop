/**
 * 文 件 名:  HeaderContext
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  17:23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.core;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

/**
 * <请求头上下文>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/29 17:23
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class HeaderContext {

    /** 请求头上下文 */
    private static final ThreadLocal<HeaderContext> headerTL = new ThreadLocal<>();

    /** 请求头信息 */
    private Map<String, String> header = Maps.newConcurrentMap();

    /**
     * 获取HeaderContext
     * @return
     */
    public static HeaderContext getHeaderContext() {
        HeaderContext htx = headerTL.get();
        return Objects.isNull(htx) ? new HeaderContext() : htx;
    }

    /**
     *
     * @param ctx
     */
    public static void set(HeaderContext ctx) {
        if (ctx == null) {
            headerTL.remove();
        } else {
            headerTL.set(ctx);
        }
    }

    /**
     * 添加请求头
     * @param key
     * @param value
     */
    public void addHeader(String key, String value) {
        headerTL.get().getHeader().put(key, value);
    }

    /**
     * 清空信息
     */
    public static void clear() {
        headerTL.get().getHeader().clear();
        headerTL.remove();
    }
}
