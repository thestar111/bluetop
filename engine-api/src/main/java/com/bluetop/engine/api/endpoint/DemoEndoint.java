/**
 * 文 件 名:  DemoEndoint
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  5:01
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.endpoint;

import com.bluetop.engine.api.bean.Application;
import com.bluetop.engine.api.bean.R;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/29 5:01
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@RestController
public class DemoEndoint {

    @PostMapping(path = "/testForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<R> testForm(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "password", required = false) String password,
                            @RequestPart(value = "file", required = false) MultipartFile file) {
        System.out.println(name + " " + password + " " + file.getName());
        return Mono.just(R.success(name));
    }

    @PostMapping(path = "/demo4", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<R> demo4(@RequestPart(value = "file", required = false) MultipartFile file) {
        System.out.println(file.getName());
        return Mono.just(R.success(file.getName()));
    }

    @PostMapping(path = "/testQueryString")
    public Mono<R> testQueryString(@RequestParam("name") String name,
                            @RequestParam("password") String password) {
        System.out.println(name + "" + password);
        return Mono.just(R.success(name));
    }

    @PostMapping(path = "/demo2/{keyword}")
    public Mono<R> test2(@PathVariable("keyword") String keyword,
                                   @RequestParam("code") String code) {
        System.out.println(keyword + "" + code);
        return Mono.just(R.success(code));
    }

    @PostMapping(path = "/demo3")
    public Mono<R> test2(@RequestParam("code") String code, @RequestBody Application application) {
        System.out.println(application.toString() + "" + code);
        return Mono.just(R.success(code));
    }
}
