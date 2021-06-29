/**
 * 文 件 名:  CustomSpringFormEncoder
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  6:20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.core;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.singletonMap;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/29 6:20
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public class CustomSpringFormEncoder extends SpringFormEncoder {

    public CustomSpringFormEncoder (Encoder delegate) {
        super(delegate);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        if (Map.class.isAssignableFrom(object.getClass())) {
            Map<String, Object> data = (Map<String, Object>) object;
            Set<String> nullSet = new HashSet<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                if (entry.getValue() == null) {
                    nullSet.add(entry.getKey());
                }
            }
            for (String s : nullSet) {
                data.remove(s);
            }
            super.encode(data, MAP_STRING_WILDCARD, template);
            return;

        } else if (bodyType.equals(MultipartFile.class)) {
            MultipartFile file = (MultipartFile) object;
            Object data = singletonMap(file.getName(), object);
            super.encode(data, MAP_STRING_WILDCARD, template);
            return;

        } else if (bodyType.equals(MultipartFile[].class)) {
            MultipartFile[] file;
            file = (MultipartFile[]) object;
            Object data = singletonMap(file.length == 0 ? "" : file[0].getName(), object);
            super.encode(data, MAP_STRING_WILDCARD, template);
            return;
        }
        super.encode(object, bodyType, template);
    }
}
