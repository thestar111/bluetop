/**
 * 文 件 名:  DataSourceHolder
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  3:37
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.config;

import com.bluetop.engin.api.cons.DataBaseType;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/6 3:37
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> DATASOURCE = new ThreadLocal<>();

    public static void setDatasource(String datasource){
        DATASOURCE.set(datasource);
    }

    public static String getDatasource(){
        if(true){
            return DataBaseType.MYSQL.name();
        }else{
            return DataBaseType.H2.name();
        }
    }
}
