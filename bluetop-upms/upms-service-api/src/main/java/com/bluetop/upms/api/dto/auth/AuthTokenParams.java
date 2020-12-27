package com.bluetop.upms.api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel("获取token参数实体")
@Data
public class AuthTokenParams implements Serializable {

    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "所属项目key", required = true)
    private String applicationKey;
}
