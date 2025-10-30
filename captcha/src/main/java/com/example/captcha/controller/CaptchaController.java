package com.example.captcha.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.example.captcha.model.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    private static final long time = 60 * 1000;
    @Autowired
    private CaptchaProperties captchaProperties;
    @RequestMapping("/get")
    public void getCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());
        lineCaptcha.write(response.getOutputStream());
        response.setContentType("image/jpeg");
        response.setHeader("Progma", "No-cache");
        session.setAttribute(captchaProperties.getSession().getKey(),lineCaptcha.getCode());
        session.setAttribute(captchaProperties.getSession().getDate(),new Date());
    }
    @RequestMapping("/check")
    public boolean check(String input,HttpSession session) {
        if(!StringUtils.hasLength(input)) {
            return false;
        }
        String saveKey = (String) session.getAttribute(captchaProperties.getSession().getKey());
        Date date = (Date) session.getAttribute(captchaProperties.getSession().getDate());
        if(input.equalsIgnoreCase(saveKey)) {
            if(date != null && System.currentTimeMillis() - date.getTime() < time) {
                return true;
            }
        }
        return false;
    }

}
