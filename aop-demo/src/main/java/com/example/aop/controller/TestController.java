package com.example.aop.controller;

import com.example.aop.aspect.MyAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {
    @RequestMapping("/t1")
    public String t1() {
        log.info("执行t1");
        return "t1";
    }

    @MyAspect
    @RequestMapping("/t2")
    public String t2() {
        log.info("执行t2");
        return "t2";
    }



}
