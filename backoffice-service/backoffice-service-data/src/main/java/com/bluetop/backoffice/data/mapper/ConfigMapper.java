/**
 * 文 件 名:  ConfigMapper
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:41
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.backoffice.data.mapper;

import com.bluetop.backoffice.data.entity.Config;

import java.util.List;

/**
 * <系统配置数据操作Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/25 22:41
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public interface ConfigMapper {

    /**
     * 加载所有配置
     *
     * @return
     */
    List<Config> getAll();
}
