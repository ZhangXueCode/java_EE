package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session) {
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }
        if("lisi".equals(userName) && "1234".equals(password)) {
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }
    @RequestMapping("/getLoginUser")
    public String getLoginUser(HttpSession session) {
        return (String) session.getAttribute("userName");
    }
}
