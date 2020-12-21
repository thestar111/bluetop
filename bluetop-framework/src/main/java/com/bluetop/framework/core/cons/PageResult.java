/**
 * 文 件 名:  Result
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  20:57
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.cons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <列表数据返回实体>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 20:57
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> extends Result<T> {

    /** 总数 */
    private int total = 0;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageResult{");
        sb.append("total=").append(total);
        sb.append(", super=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
