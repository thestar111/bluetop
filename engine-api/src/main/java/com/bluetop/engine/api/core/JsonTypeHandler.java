package com.bluetop.engine.api.core;

import cn.hutool.json.JSONUtil;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis 对象 -> json 类型转换
 *
 * @author zhouping
 * @version 1.0
 * @date 2018年4月3日
 * @time 上午10:06:43
 * @since JDK 1.8
 */
public class JsonTypeHandler<T extends Object> extends BaseTypeHandler<T> {

    private Class<T> clazz;

    public JsonTypeHandler(Class<T> clazz) {
        if (clazz == null) throw new IllegalArgumentException("Type argument cannot be null");
        this.clazz = clazz;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            if (jdbcType == null) {
                throw new TypeException("JDBC requires that the JdbcType must be specified for all nullable parameters.");
            }
            try {
                setNonNullParameter(ps, i, parameter, jdbcType);
            } catch (SQLException e) {
                throw new TypeException("Error setting null for parameter #" + i + " with JdbcType " + jdbcType + " . " +
                        "Try setting a different JdbcType for this parameter or a different jdbcTypeForNull configuration property. " +
                        "Cause: " + e, e);
            }
        } else {
            try {
                setNonNullParameter(ps, i, parameter, jdbcType);
            } catch (Exception e) {
                throw new TypeException("Error setting non null for parameter #" + i + " with JdbcType " + jdbcType + " . " +
                        "Try setting a different JdbcType for this parameter or a different configuration property. " +
                        "Cause: " + e, e);
            }
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter == null || (parameter instanceof String && StringUtils.isBlank((String) parameter))) {
            ps.setString(i, StringUtils.EMPTY);
        } else {
            ps.setString(i, JSONUtil.toJsonStr(parameter));
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        if (StringUtils.isNotBlank(result)) {
            return JSONUtil.toBean(result, clazz);
        }
        return null;
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        if (StringUtils.isNotBlank(result)) {
            return JSONUtil.toBean(result, clazz);
        }
        return null;
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        if (StringUtils.isNotBlank(result)) {
            return JSONUtil.toBean(result, clazz);
        }
        return null;
    }
}
