package com.bluetop.upms.api.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel("判断当前用户是否拥有某个角色入参实体")
@Data
public class JudgeRoleParams implements Serializable {

    @ApiModelProperty(value = "角色key", readOnly = true)
    private String roleKey;
}
