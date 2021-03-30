/**
 * 文 件 名:  Constans
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.cons;

/**
 * <常量定义>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 21:15
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public interface Constans {

    /**
     * 日志链ID
     */
    public static final String TRANCE_ID = "tranceID";

    /**
     * jwt签发者的名称
     */
    String JWT_IUSER = "cms";

    /**
     * jwt自定义属性名称
     */
    String JWT_CLIENT_USERNAME = "userName";

    /**
     * 应用key
     */
    String JWT_APPLICATION_KEY = "applicationKey";

    /**
     * 客户端传token参数名称
     */
    String JWT_CUSTOMER_TOKEN_NAME = "Authorization";

    /**
     * 超级管理员角色key
     */
    String SUPER_ADMIN_ROLE = "admin";
}
