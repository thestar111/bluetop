/**
 * 文 件 名:  ApplicationEndpoint
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  9:05
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.endpoint;

import cn.hutool.core.collection.CollectionUtil;
import com.bluetop.engine.api.bean.Application;
import com.bluetop.engine.api.bean.R;
import com.bluetop.engine.api.constant.StatusEnum;
import com.bluetop.engine.api.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * <应用路由>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 9:05
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@RestController
public class ApplicationRouter {

    @Autowired
    private ApplicationRepository applicationRepository;

    /**
     * @param application
     * @return
     */
    @PostMapping(path = "application/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<R> addApplication(@RequestBody Application application) {
        int flag = applicationRepository.addApplication(application);
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
    @PostMapping(path = "application/list")
    public Mono<R> listApplication(@RequestParam(value = "index", required = false, defaultValue = "0") Integer index,
                                   @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                   @RequestParam(value = "status", required = false, defaultValue = "enable") String status) {
        StatusEnum statusValue = StatusEnum.valueOf(status);
        if (Objects.isNull(statusValue)) {
            return Mono.empty();
        }
        List<Application> applications = applicationRepository.listApplication(index, size, status);
        if (CollectionUtil.isNotEmpty(applications)) {
            return Mono.just(R.success(applications));
        }
        return Mono.empty();
    }
}
