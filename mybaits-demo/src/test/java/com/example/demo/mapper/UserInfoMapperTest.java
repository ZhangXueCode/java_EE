package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void getUserInfoAll() {
        List<UserInfo> userInfos = userInfoMapper.getUserInfoAll();
        System.out.println(userInfos);
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(12);
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("1234");
        Integer result = userInfoMapper.insert(userInfo);
        System.out.println("result:" + result);
    }

    @Test
    void getUserInfo() {
        System.out.println(userInfoMapper.getUserInfo(1));
    }

    @Test
    void delete() {
        System.out.println(userInfoMapper.delete(5));
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(122);
        userInfo.setUsername("zhang");
        userInfo.setPassword("123334");
        userInfo.setGender(1);
        Integer result = userInfoMapper.insert2(userInfo);
        System.out.println("result:" + result + " id: " + userInfo.getId());
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhang");
        userInfo.setId(3);
        Integer result = userInfoMapper.update(userInfo);
        System.out.println("result:" + result);
    }

    @Test
    void delete2() {
        Integer result = userInfoMapper.delete2("zhaoliu");
        System.out.println("result:" + result);
    }
}