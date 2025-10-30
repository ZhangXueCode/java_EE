package com.example.blog.service;

import com.example.blog.mapper.BlogMapper;
import com.example.blog.mapper.UserMapper;
import com.example.blog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserMapper userMapper;

    public UserInfo selectByName(String userName) {
        return userMapper.selectByName(userName);
    }

    public UserInfo getUserInfo(Integer userId) {
        return userMapper.selectById(userId);
    }

    public UserInfo selectById(Integer blogId) {
        Integer id = blogMapper.selectById(blogId).getUserId();
        return userMapper.selectById(id);
    }

}
