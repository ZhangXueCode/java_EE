package com.example.demo;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisDemoApplicationTests {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Test
	void contextLoads() {
		List<UserInfo> userInfos = userInfoMapper.getUserInfoAll();
		System.out.println(userInfos);

	}

}
