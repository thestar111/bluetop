package com.bluetop.upms.biz.cons;

/**
 * <系统参数配置类，配置了系统用到参数>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public interface Config {

    /**
     * 系统语言环境，默认为中文zh
     */
    String LANGUAGE = "zh";

    /**
     * 系统国家环境，默认为中国CN
     */
    String COUNTRY = "CN";

    /**
     * servletContext
     */
    String SERVLETCONTEXT_KEY = "servletContext";

    /**
     * 提示信息配置文件名
     */
    String MESSAGE = "i18n/messages";
}
