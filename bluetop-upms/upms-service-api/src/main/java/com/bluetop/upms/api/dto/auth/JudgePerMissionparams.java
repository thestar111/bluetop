package com.bluetop.upms.api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel("鉴权入参实体")
@Data
public class JudgePerMissionparams implements Serializable {

    @ApiModelProperty(value = "需要鉴权的地址", required = true)
    private String urlAddress;
}
