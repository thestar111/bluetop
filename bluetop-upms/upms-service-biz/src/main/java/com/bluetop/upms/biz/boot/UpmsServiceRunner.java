package com.bluetop.upms.biz.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <系统启动入口>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.bluetop.upms")
@MapperScan(basePackages = {"com.bluetop.upms.biz.database.mapper"})
public class UpmsServiceRunner {

    public static void main(String[] args) {
        SpringApplication.run(UpmsServiceRunner.class, args);
    }
}
