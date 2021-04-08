/**
 * 文 件 名:  DynamicDataSource
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  3:35
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * <动态数据源>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/6 3:35
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 动态数据源
     *
     * @param defaultTargetDataSource
     * @param targetDataSource
     */
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object,Object> targetDataSource){
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }

    /**
     * 获取数据源
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDatasource();
    }
}
