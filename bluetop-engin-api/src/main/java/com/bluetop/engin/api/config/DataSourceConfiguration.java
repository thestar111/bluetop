/**
 * 文 件 名:  DataSourceConfiguration
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  3:27
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.config;

import com.bluetop.engin.api.cons.DataBaseType;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <数据源配置>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/6 3:27
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Configuration
public class DataSourceConfiguration {

    @Autowired
    private Environment environment;


    /**
     * 默认的H2内存数据库，在没有安装系统之前使用该数据库
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    @ConditionalOnProperty(value = "db.type", havingValue = "H2", matchIfMissing = true)
    public DataSource h2DataSource(){
        log.info("【{}】 use default datasource : H2. start load H2 config.", getClass().getSimpleName());
        DataSource dataSource = DataSourceBuilder.create().driverClassName("org.h2.Driver").build();
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        return dataSource;
    }

    /**
     * 配置数据库后使用该数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    @ConditionalOnProperty(value = "db.type", havingValue = "mysql")
    public DataSource mysqlDataSource(){
        log.info("【{}】 use mysql datasource : mysql. start load mysql config.", getClass().getSimpleName());
        DataSource dataSource = DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver").build();
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        return dataSource;
    }

    /**
     * 动态数据源
     *
     * @param h2DataSource
     * @param mysqlDataSource
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(DataSource h2DataSource,DataSource mysqlDataSource){
        Map<Object,Object> targetDataSource = new HashMap<>(2);
        targetDataSource.put(DataBaseType.H2.name(),h2DataSource);
        targetDataSource.put(DataBaseType.MYSQL.name(),mysqlDataSource);
        if(DataBaseType.MYSQL.name().equals(environment.getProperty("db.type"))){
            return new DynamicDataSource(mysqlDataSource,targetDataSource);
        }else{
            return new DynamicDataSource(h2DataSource,targetDataSource);
        }
    }


    /**
     * 配置JDK代理
     *
     * @return
     */
    /*@Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut jdkRegexpMethodPointcut(){
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPatterns("com.ramostear.blogdemo.*");
        return pointcut;
    }*/

    /**
     * 配置AOP通知
     *
     * @param druidStatInterceptor
     * @param pointcut
     * @return
     */
    /*@Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut pointcut){
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(druidStatInterceptor);
        return advisor;
    }*/
}
