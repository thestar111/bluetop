/**
 * 文 件 名:  CallerService
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.service;

import com.bluetop.engine.api.bean.Application;
import com.bluetop.engine.api.core.FeignRequestInterceptor;
import com.bluetop.engine.api.core.Header;
import com.bluetop.engine.api.core.HeaderContext;
import com.bluetop.engine.api.core.HttpFeignClient;
import com.google.common.collect.Maps;
import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Map;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 21:15
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Component
@Import(FeignClientsConfiguration.class)
public class CallerService {

    private HttpFeignClient httpFeignClient;

    @Autowired
    public CallerService(Decoder decoder, Encoder encoder) {
        httpFeignClient = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .requestInterceptor(new FeignRequestInterceptor())
                .contract(new SpringMvcContract())
                .target(Target.EmptyTarget.create(HttpFeignClient.class));
    }

    /**
     *
     * @param url
     * @param object
     * @return
     * @throws Exception
     */
    @Header
    public Object doPost(String url, Application object) throws Exception{
        Map<String, String> header = Maps.newConcurrentMap();
        header.put("token", "1243213213213");
        HeaderContext.getHeaderContext().getHeader().putAll(header);
        return httpFeignClient.doPost(new URI(url), object);
    }

    /**
     *
     * @param url
     * @param object
     * @return
     * @throws Exception
     */
    @Header
    public Object doGet(String url, Object object) throws Exception{
        Map<String, String> header = Maps.newConcurrentMap();
        header.put("token", "1243213dfge213213");
        HeaderContext.getHeaderContext().getHeader().putAll(header);
        return httpFeignClient.doGet(new URI(url), object);
    }

    /**
     *
     * @param url
     * @param object
     * @return
     * @throws Exception
     */
    @Header
    public Object formData(String url, Map<String, Object> object) throws Exception{
        HeaderContext ctx = new HeaderContext();
        Map<String, String> header = Maps.newConcurrentMap();
        header.put("token", "124321321321ghh3");
        header.put("Content-Type", "multipart/form-data");
        ctx.setHeader(header);
        HeaderContext.set(ctx);
        object.put("file", new File("D:\\ChromeCoreDownloads\\settings.xml"));
        return httpFeignClient.form(new URI(url), object);
    }

    /**
     *
     * @param url
     * @param object
     * @return
     * @throws Exception
     */
    @Header
    public Object form(String url, Map<String, Object> object) throws Exception{
        HeaderContext ctx = new HeaderContext();
        Map<String, String> header = Maps.newConcurrentMap();
        header.put("token", "124321321321ghh3");
        header.put("Content-Type", "multipart/form-data");
        ctx.setHeader(header);
        HeaderContext.set(ctx);
        File file = new File("D:\\ChromeCoreDownloads\\settings.xml");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);
        object.put("file", new Byte[1024]);
        return httpFeignClient.form(new URI(url), object);
    }
}
