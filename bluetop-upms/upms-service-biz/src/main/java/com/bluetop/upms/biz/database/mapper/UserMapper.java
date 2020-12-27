package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUserByUserName(String name);

}