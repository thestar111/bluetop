/**
 * 文 件 名:  FeignClientConfiguration
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:55
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.config;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * <Feign配置>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/8/9 22:55
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Component
public class FeignClientConfiguration implements BeanFactoryPostProcessor {

    /** 包路径 */
    private String path = "com.bluetop.engin.api.client";

    /**
     * 默认前缀
     */
    private static final String DEFAULT_PREFIX = "http://";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        List<String> classes = scan();
        if (classes == null) {
            return;
        }
        Feign.Builder builder = getFeignBuilder();
        if (classes.size() > 0) {
            Class<?> targetClass = null;
            Api api = null;
            for (String claz : classes) {
                try {
                    targetClass = Class.forName(claz);
                    api = targetClass.getAnnotation(Api.class);
                    if (null == api) {
                        continue;
                    }
                    String url = api.url();
                    if (url.indexOf(DEFAULT_PREFIX) != 0) {
                        url = api.prefix() + url;
                    }
                    Object target = builder.target(targetClass, url);
                    configurableListableBeanFactory.registerSingleton(targetClass.getName(), target);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    /**
     * 构建Feign对象
     *
     * @return
     */
    public Feign.Builder getFeignBuilder() {
        Feign.Builder builder = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(10, SECONDS, 60, SECONDS, true))
                .logLevel(Logger.Level.FULL)
                .retryer(new Retryer.Default(5000, 5000, 3));
        return builder;
    }

    /**
     * 扫描路径下的class
     *
     * @return
     */
    public List<String> scan() {
        // 扫描package下的class
        ScanResult result = new FastClasspathScanner(path).matchClassesWithAnnotation(Api.class, (Class<?> aClass) -> {
        }).scan();
        if (result != null) {
            return result.getNamesOfAllInterfaceClasses();
        }
        return null;
    }
}
