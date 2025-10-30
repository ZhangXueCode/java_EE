package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.lang.ref.SoftReference;
import java.util.List;

@Mapper
public interface UserInfoXmlMapper {
    Integer insert(UserInfo userInfo);

    Integer delete(Integer id);

    Integer update(Integer age,String username);

    List<UserInfo> selectAll();

    Integer insert2(UserInfo userInfo);

    List<UserInfo> selectByUsername(UserInfo userInfo);

    Integer updateBy(UserInfo userInfo);

    Integer delete2(List<Integer> ids);

    Integer insertP(List<UserInfo> userInfos);



}
