package com.bluetop.upms.api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <用户鉴权地址参数>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午ø
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@ApiModel("鉴权入参实体")
@Data
public class JudgePerMissionParams implements Serializable {

    /**
     * 鉴权地址
     */
    @ApiModelProperty(value = "需要鉴权的地址", required = true)
    private String urlAddress;
}
