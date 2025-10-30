package com.example.blog.mapper;

import com.example.blog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user_info where delete_flag = 0 and user_name = #{userName}")
    UserInfo selectByName(String userName);

    @Select("select * from user_info where delete_flag = 0 and id = #{id}")
    UserInfo selectById(Integer id);
}
