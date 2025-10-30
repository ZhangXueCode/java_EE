package com.example.trans.service;

import com.example.trans.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public Integer insert(String userName,String password) {
        return userMapper.insert(userName,password);
    }
}
