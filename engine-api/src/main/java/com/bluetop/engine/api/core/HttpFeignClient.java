/**
 * 文 件 名:  HttpFeignClient
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:03
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.core;

import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.Map;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 21:03
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@FeignClient(name = "http-feign-client")
public interface HttpFeignClient {

    /**
     * POST请求
     * @param baseUri
     * @param data
     * @return
     */
    @PostMapping
    Object doPost(URI baseUri, @RequestBody Object data);

    /**
     * GET请求
     * @param baseUri
     * @param data
     * @return
     */
    @GetMapping
    Object doGet(URI baseUri, @RequestBody Object data);

    /**
     * PUT请求
     * @param baseUri
     * @param data
     * @return
     */
    @PutMapping
    Object doPut(URI baseUri, @RequestBody Object data);

    /**
     * FORM表单
     * @param baseUri
     * @param data
     * @return
     */
    @PostMapping
    Object form(URI baseUri, @RequestParam Map<String, Object> data);
}
