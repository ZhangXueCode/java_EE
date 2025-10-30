package com.example.blog.controller;

import com.example.blog.constant.Constants;
import com.example.blog.mapper.UserMapper;
import com.example.blog.model.Result;
import com.example.blog.model.UserInfo;
import com.example.blog.service.UserService;
import com.example.blog.utils.JwtUtils;
import com.example.blog.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Result login(String userName,String password) {
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("密码或账户为空");
        }
        UserInfo userInfo = userService.selectByName(userName);
        if(userInfo == null) {
            return Result.fail("没有这个账户");
        }
        if(!SecurityUtils.verify(password,userInfo.getPassword())) {
            return Result.fail("密码错误");
        }
        //返回token
        Map<String,Object> claim = new HashMap<>();
        claim.put(Constants.TOKEN_ID, userInfo.getId());
        claim.put(Constants.TOKEN_USERNAME, userInfo.getUserName());
        String token = JwtUtils.genJwtToken(claim);
        log.info("UserController#login 返回结果token:{}",token);
        return Result.success(token);
    }

    /**
     * 获取用户信息
     */
    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo(HttpServletRequest request) {
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        Integer userId = JwtUtils.getIdByToken(token);
        if(userId <= 0) {
            return null;
        }
        UserInfo userInfo = userService.getUserInfo(userId);
        return userInfo;

    }

    /**
     * 通过博客id得到用户id再获取用户信息
     * @param blogId
     * @return
     */
    @RequestMapping("/selectById")
    public UserInfo selectById(Integer blogId) {
        if(blogId <= 0) {
            return null;
        }
        return userService.selectById(blogId);
    }


}
