/**
 * 文 件 名:  ApiCache
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:36
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.cache;

import com.bluetop.engine.api.bean.Application;
import com.bluetop.engine.api.bean.Endpoint;
import com.bluetop.engine.api.repository.ApplicationRepository;
import com.bluetop.engine.api.repository.EndpointRepository;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/29 22:36
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Component
public class EndpointCache {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private EndpointRepository endpointRepository;


    private LoadingCache<Integer, Endpoint> endpointCache = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .refreshAfterWrite(1, TimeUnit.HOURS)
            .expireAfterWrite(59, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, Endpoint>() {
                @Override
                public Endpoint load(Integer id) throws Exception {
                    return endpointRepository.getById(id);
                }
            });

    private LoadingCache<Integer, Application> applicationCache = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .refreshAfterWrite(1, TimeUnit.HOURS)
            .expireAfterWrite(59, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, Application>() {
                @Override
                public Application load(Integer id) throws Exception {
                    return applicationRepository.getById(id);
                }
            });


    /**
     * 获取Endpoint
     * @param id
     * @return
     */
    public Endpoint getEndpoint(Integer id) {
        try {
            Endpoint endpoint = endpointCache.get(id);
            if (Objects.isNull(endpoint)) {
                return null;
            }
            Application application = applicationCache.get(endpoint.getApplicationId());
            if (Objects.isNull(application)) {
                return null;
            }
            endpoint.setUrl(application.getUrl());
            return endpoint;
        } catch (ExecutionException e) {
            log.error("{} get endpoint falied. endpoint id : {}", getClass().getSimpleName(), id);
        }
        return null;
    }
}
