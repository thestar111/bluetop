package com.bluetop.framework.core.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.type.MapType;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * <JSON处理工具>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/23 6:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public final class JsonUtils {

    /**
     * JsonMapper
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        SimpleModule booleanModule = new SimpleModule("BooleanConvertModule");
        booleanModule.addDeserializer(Boolean.class, new NumberDeserializers.BooleanDeserializer(Boolean.class, Boolean.FALSE));
        OBJECT_MAPPER.registerModule(booleanModule);
        SimpleModule decimalModule = new SimpleModule("BigDecimalConvertModule");
        decimalModule.addSerializer(BigDecimal.class, new ToStringSerializer());
        OBJECT_MAPPER.registerModule(decimalModule);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * JSON序列化
     *
     * @param object
     * @param output
     */
    public static void toJson(Object object, OutputStream output) {
        if (object != null) {
            try {
                OBJECT_MAPPER.writeValue(output, object);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    /**
     * JSON序列化
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        if (object == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.writeValueAsString(object);
            } catch (JsonProcessingException var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    /**
     * Json反序列化
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(json, clazz);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    /**
     * Json反序列化
     *
     * @param is
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(InputStream is, Class<T> clazz) {
        if (is == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(is, clazz);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    /**
     * Json反序列化
     *
     * @param is
     * @param ref
     * @param <T>
     * @return
     */
    public static <T> T toBean(InputStream is, TypeReference<T> ref) {
        if (is == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(is, ref);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    /**
     * Json反序列化
     *
     * @param json
     * @param ref
     * @param <T>
     * @return
     */
    public static <T> T toBean(String json, TypeReference<T> ref) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(json, ref);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    /**
     * Json反序列化
     *
     * @param json
     * @param javaType
     * @param <T>
     * @return
     */
    public static <T> T toBean(String json, JavaType javaType) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(json, javaType);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    /**
     * 获取JavaType
     *
     * @param collectionClass
     * @param elementClasses
     * @return
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 获取MapType
     *
     * @param keyClass
     * @param valueClass
     * @return
     */
    public static MapType getMapType(Class<?> keyClass, Class<?> valueClass) {
        return OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, keyClass, valueClass);
    }

    /**
     * 类型转换
     *
     * @param fromValue
     * @param toValueType
     * @param <T>
     * @return
     */
    public static <T> T convertType(Object fromValue, JavaType toValueType) {
        return OBJECT_MAPPER.convertValue(fromValue, toValueType);
    }

    public static String toFormatedJson(Object bean) {
        return bean == null ? null : format(toJson(bean));
    }

    /**
     * 格式化JSON
     *
     * @param jsonStr
     * @return
     */
    public static String format(String jsonStr) {
        if (jsonStr != null && jsonStr != "") {
            int level = 0;
            StringBuffer jsonForMatStr = new StringBuffer();

            for (int i = 0; i < jsonStr.length(); ++i) {
                char c = jsonStr.charAt(i);
                if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                    jsonForMatStr.append(getLevelStr(level));
                }
                switch (c) {
                    case ',':
                        jsonForMatStr.append(c + "\n");
                        break;
                    case '[':
                    case '{':
                        jsonForMatStr.append(c + "\n");
                        ++level;
                        break;
                    case ']':
                    case '}':
                        jsonForMatStr.append("\n");
                        --level;
                        jsonForMatStr.append(getLevelStr(level));
                        jsonForMatStr.append(c);
                        break;
                    default:
                        jsonForMatStr.append(c);
                }
            }

            return jsonForMatStr.toString();
        } else {
            return null;
        }
    }

    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();

        for (int levelI = 0; levelI < level; ++levelI) {
            levelStr.append("\t");
        }

        return levelStr.toString();
    }
}
