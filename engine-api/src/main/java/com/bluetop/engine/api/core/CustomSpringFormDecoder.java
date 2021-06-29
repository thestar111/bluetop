/**
 * 文 件 名:  CustomSpringFormDecoder
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  6:21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.core;

import cn.hutool.json.JSONUtil;
import feign.FeignException;
import feign.Response;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/29 6:21
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public class CustomSpringFormDecoder extends SpringDecoder {

    public CustomSpringFormDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        super(messageConverters);
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        String rsp = IOUtils.toString(response.body().asInputStream(), "UTF-8");
        return JSONUtil.toBean(rsp, Object.class);
    }
}