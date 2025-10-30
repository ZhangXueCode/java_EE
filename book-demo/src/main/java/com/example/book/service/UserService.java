package com.example.book.service;

import com.example.book.mapper.UserMapper;
import com.example.book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public UserInfo select(String userName) {
        return userMapper.selectByName(userName);
    }
}
