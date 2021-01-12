package com.bluetop.upms.biz.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bluetop.upms.biz.database.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}