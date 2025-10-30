package com.example.book.controller;

import com.example.book.constant.Constants;
import com.example.book.mapper.UserMapper;
import com.example.book.model.Result;
import com.example.book.model.UserInfo;
import com.example.book.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",produces = "application/json")
    public Result login(String userName, String password, HttpSession session) {
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("用户或密码为空");
        }
        UserInfo userInfo = userService.select(userName);
        if(userInfo == null) {
            return Result.fail("用户未登录");
        }
        if(!password.equals(userInfo.getPassword())) {
            return Result.fail("密码错误");
        }
        session.setAttribute(Constants.USER_SESSION_KEY,userInfo);
        return Result.success("");
    }
}
