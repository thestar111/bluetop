/**
 * 文 件 名:  EndpointRouter
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  9:06
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.endpoint;

import cn.hutool.core.collection.CollectionUtil;
import com.bluetop.engine.api.bean.Endpoint;
import com.bluetop.engine.api.bean.R;
import com.bluetop.engine.api.cache.EndpointCache;
import com.bluetop.engine.api.constant.StatusEnum;
import com.bluetop.engine.api.repository.EndpointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 9:06
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@RestController
public class EndpointRouter {

    @Autowired
    private EndpointRepository endpointRepository;

    @Autowired
    private EndpointCache endpointCache;

    /**
     * 添加
     * @param endpoint
     * @return
     */
    @PostMapping(path = "endpoint/add")
    public Mono<R> addEndpoint(@RequestBody Endpoint endpoint) {
        int flag = endpointRepository.addEndpoint(endpoint);
        if (flag > 0) {
            return Mono.just(new R());
        }
        return Mono.just(R.failed());
    }

    /**
     * @param index
     * @param size
     * @param status
     * @return
     */
    @PostMapping(path = "endpoint/list")
    public Mono<R> listEndpoint(@RequestParam(value = "index", required = false, defaultValue = "0") Integer index,
                                   @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                   @RequestParam(value = "status", required = false, defaultValue = "enable") String status) {
        StatusEnum statusValue = StatusEnum.valueOf(status);
        if (Objects.isNull(statusValue)) {
            return Mono.empty();
        }
        List<Endpoint> endpoints = endpointRepository.listEndpoint(index, size, status);
        if (CollectionUtil.isNotEmpty(endpoints)) {
            return Mono.just(R.success(endpoints));
        }
        return Mono.empty();
    }

    /**
     * @param id
     * @return
     */
    @PostMapping(path = "endpoint/getById")
    public Mono<R> getById(@RequestParam(value = "id") Integer id) {
        Endpoint endpoint = endpointCache.getEndpoint(id);
        return Mono.just(R.success(endpoint));
    }
}
