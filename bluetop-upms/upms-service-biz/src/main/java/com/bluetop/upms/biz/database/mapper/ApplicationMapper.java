package com.bluetop.upms.biz.database.mapper;

import com.bluetop.upms.biz.database.entity.Application;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicationMapper {

    Application getApplicationByAppkey(String applicationKey);

}