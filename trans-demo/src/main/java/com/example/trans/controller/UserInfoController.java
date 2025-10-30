package com.example.trans.controller;

import com.example.trans.mapper.UserMapper;
import com.example.trans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserService userService;
    @RequestMapping("/insert")
    public Integer insert(String userName,String password) {
        return userService.insert(userName,password);
    }
}
