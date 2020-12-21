/**
 * 文 件 名:  ErrorCodeEnum
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Pine.Z
 * 修改时间:  2019/11/13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.cons;

import lombok.Getter;

/**
 * <错误码枚举值>
 *
 * @author Pine.Z
 * @version 2019/11/13
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
public enum IErrorCodeEnum {
    /**
     * 成功
     */
    Business_success(0, "Success."),

    /**
     * 业务失败
     */
    Business_not_success(-100000, "Operate Failed, Try Again."),

    /**
     * 错误码
     */
    Param_does_not_exist(100001, "Params Not exist."),

    /**
     * 参数不正确
     */
    Param_does_not_correct(100002, "Params not correct."),

    /**
     * 系统异常
     */
    System_error(100009, "System Error."),

    /**
     * 非法请求
     */
    Request_invalid(-200000, "Invalid Request."),

    /**
     * 文件IO异常
     */
    File_create_error(-400000, "File Error."),

    /**
     * 文件名称无效字符异常
     */
    File_invalid_character_error(-400001, "File Invalid Character."),

    /**
     * 文件找不到
     */
    File_not_found_error(-400004, "File Not Found."),

    /**
     * 用户不存在
     */
    User_not_found_error(-500000, "User Not Found."),

    /**
     * 用户TOKEN已过期
     */
    User_token_expired(-900000, "Token has expired."),

    /**
     * 用户名密码错误
     */
    User_pass_not_correct(-900001, "UserName Or Password not correct."),

    /**
     * 服务不可用
     */
    Service_not_available(900009, "Service Not Available.");

    /**
     * 构造方法
     *
     * @param errorCode
     * @param errorMsg
     */
    IErrorCodeEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 错误码
     */
    private int errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;
}
