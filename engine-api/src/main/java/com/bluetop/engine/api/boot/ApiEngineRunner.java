/**
 * 文 件 名:  ApiEngineRunner
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  0:03
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.boot;

import com.bluetop.engine.api.core.CustomSpringFormDecoder;
import com.bluetop.engine.api.core.CustomSpringFormEncoder;
import feign.Request;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

/**
 * <启动入口类>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 0:03
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.bluetop.engine.api"})
@MapperScan(basePackages = "com.bluetop.engine.api.repository")
public class ApiEngineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiEngineRunner.class, args);
    }

    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder feignFormEncoder() {
        return new CustomSpringFormEncoder(new SpringEncoder(messageConverters));
    }

    @Bean
    @Primary
    @Scope("prototype")
    public Decoder feignFormDecoder() {
        return new CustomSpringFormDecoder(messageConverters);
    }

    @Bean
    @Primary
    @Scope("prototype")
    public Request.Options feignOptions() {
        return new Request.Options(2 * 60 * 1000, 15 * 60 * 1000);
    }
}
