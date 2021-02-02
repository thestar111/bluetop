package com.bluetop.framework.core.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <分页请求VO>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/26 9:54 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class PageRequest implements Serializable {

    /** 默认每页大小 */
    private static final Integer DEFAULT_SIZE = 20;

    /** 页码索引 */
    private Integer index = 1;

    /** 每页显示数量 */
    private Integer size = DEFAULT_SIZE;
}
