/**
 * 文 件 名:  Api
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  23:00
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.config;

import java.lang.annotation.*;

/**
 * <API自定义注解>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/8/9 23:00
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Api {

    /**
     * URl 请求地址
     *
     * @return
     */
    String url();

    /**
     * 默认前缀
     *
     * @return
     */
    String prefix() default "http://";
}
