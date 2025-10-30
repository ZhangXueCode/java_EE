package com.example.trans.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user_info (user_name,password) values (#{userName},#{password}")
    Integer insert(String userName,String password);
}
