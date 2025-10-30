package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Slf4j
@Aspect
//@Component
public class AspectDemo2 {
    @Before("com.example.aop.aspect.AspectDemo.pt()")
    public void doBefore() {
        log.info("do before2");
    }
    @After("com.example.aop.aspect.AspectDemo.pt()")
    public void doAfter() {
        log.info("do after2");
    }
    @Around("com.example.aop.aspect.AspectDemo.pt()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("do around before2");
        Object proceed = joinPoint.proceed();
        log.info("do around after2");
        return proceed;
    }
}
