package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectDemo3 {
    @Before("@annotation(com.example.aop.aspect.MyAspect)")
    public void MyAspect() {
        log.info("do MyAspect before");
    }
}
