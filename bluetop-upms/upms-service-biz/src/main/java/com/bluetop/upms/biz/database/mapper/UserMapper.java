package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <用户Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface UserMapper {

    User getUserByUserName(String name);

}