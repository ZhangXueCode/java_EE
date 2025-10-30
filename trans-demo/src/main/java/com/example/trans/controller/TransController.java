package com.example.trans.controller;

import com.example.trans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TransController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(String userName,String password) {
        return userService.insert(userName,password);
    }
}
