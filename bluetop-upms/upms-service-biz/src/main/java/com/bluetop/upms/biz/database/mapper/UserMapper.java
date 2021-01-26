package com.bluetop.upms.biz.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bluetop.upms.biz.database.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <系统用户数据Mapper>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/14 12:10 下午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}