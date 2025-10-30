package com.example.blog.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SecurityUtils {
    /**
     * 加密
     * @param password 注册时的密码
     * @return 盐值+md5(密码+盐值) -> 返回存在数据库中的值
     */
    public static String encrypt(String password) {
        String salt = UUID.randomUUID().toString().replace("-","");
        String finalPassword = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        return salt + finalPassword;
    }

    /**
     * 验证密码  inputPassword用户登录时输入的密码  sqlPassword是数据库中存的  盐值+md5(密码+盐值)
     * @return
     */

    public static boolean verify(String inputPassword,String sqlPassword) {
        if(!StringUtils.hasLength(inputPassword)) {
            return false;
        }
        if(!StringUtils.hasLength(sqlPassword) || sqlPassword.length() != 64) {
            return false;
        }
        String salt = sqlPassword.substring(0,32);
        String finalPassword = DigestUtils.md5DigestAsHex((inputPassword + salt).getBytes());
        return (salt + finalPassword).equals(sqlPassword);
    }

}
