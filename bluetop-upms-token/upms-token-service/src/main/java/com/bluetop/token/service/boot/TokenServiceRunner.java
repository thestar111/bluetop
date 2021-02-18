package com.bluetop.token.service.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <启动入口>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/26 12:01 下午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.bluetop.token")
public class TokenServiceRunner {

    public static void main(String[] args) {
        SpringApplication.run(TokenServiceRunner.class, args);
    }
}
