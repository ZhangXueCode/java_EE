package com.example.book.mapper;

import com.example.book.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user_info where user_name = #{userName}")
    UserInfo selectByName(String userName);
}
