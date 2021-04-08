/**
 * 文 件 名:  TableDetailInfo
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:33
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <表单详细信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/3 21:33
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="明细表单信息")
public class TableDetailInfo implements Comparable<TableDetailInfo> {

    /** 表单顺序号 */
    @ApiModelProperty(value = "明细表序号", required = true)
    private Integer order;

    /** 表单信息 */
    @ApiModelProperty(value = "明细表单信息")
    private List<List<NameAndValue>> tableInfos;

    /**
     * 比较
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(TableDetailInfo o) {
        return Integer.valueOf(order).compareTo(Integer.valueOf(o.getOrder()));
    }
}
