package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoXmlMapperTest {
    @Autowired
    private UserInfoXmlMapper userInfoXmlMapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("tt");
        userInfo.setPassword("123456");
        userInfo.setAge(19);
        userInfo.setGender(2);
        System.out.println(userInfoXmlMapper.insert(userInfo));
    }

    @Test
    void delete() {
        System.out.println(userInfoXmlMapper.delete(14));
    }

    @Test
    void update() {
        System.out.println(userInfoXmlMapper.update(12,"zhang"));
    }

    @Test
    void selectAll() {
        System.out.println(userInfoXmlMapper.selectAll());
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("tt");
        userInfo.setAge(19);
//        userInfo.setGender(2);
        userInfo.setPassword("123456");
        System.out.println(userInfoXmlMapper.insert2(userInfo));
    }

    @Test
    void selectByUsername() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setId(1);
//        userInfo.setUsername("admin");
//        userInfo.setPassword("admin");
//        userInfo.setGender(1);
        System.out.println(userInfoXmlMapper.selectByUsername(userInfo));

    }

    @Test
    void updateBy() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
//        userInfo.setGender(1);
        userInfo.setAge(19);
        System.out.println(userInfoXmlMapper.updateBy(userInfo));
    }

    @Test
    void delete2() {
        List<Integer> ids = Arrays.asList(new Integer[]{15,16,17,18});
        userInfoXmlMapper.delete2(ids);
    }

    @Test
    void insertP() {
        List<UserInfo> userInfos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername("tt");
            userInfo.setAge(19);
            userInfo.setGender(2);
            userInfo.setPassword("123456");
            userInfos.add(userInfo);
        }
        System.out.println(userInfoXmlMapper.insertP(userInfos));
    }
}