package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.lang.ref.SoftReference;
import java.util.List;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info")
    List<UserInfo> getUserInfoAll();

    @Select("select * from user_info where id = #{id}")
    List<UserInfo> getUserInfo(Integer id);

    @Insert("insert into user_info (username,age,password) values (#{username},#{age}," +
            "#{password})")
    Integer insert(UserInfo userInfo);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user_info (username,age,password,gender) values (#{username},#{age}," +
            "#{password},#{gender})")
    Integer insert2(UserInfo userInfo);

    @Delete("delete from user_info where id = #{id}")
    Integer delete(Integer id);

    @Delete("delete from user_info where username = #{username}")
    Integer delete2(String username);

    @Update("update user_info set username = #{username} where id = #{id}")
    Integer update(UserInfo userInfo);

}
