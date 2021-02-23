package com.bluetop.upms.api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <授权服务>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午ø
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@ApiModel("获取token参数实体")
public class AuthTokenParams implements Serializable {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    /**
     * 项目key
     */
    @ApiModelProperty(value = "所属项目key", required = true)
    private String key;
}
