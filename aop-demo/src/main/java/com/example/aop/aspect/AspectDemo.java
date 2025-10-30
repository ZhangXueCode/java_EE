package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(17)
@Slf4j
@Aspect
//@Component
public class AspectDemo {
    @Pointcut("execution(* com.example.aop.controller..*(..))")
    public void pt(){};

    @Before("pt()")
    public void doBefore() {
        log.info("do before");
    }
    @After("pt()")
    public void doAfter() {
        log.info("do after");
    }
    @Around("pt()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("do around before");
        Object proceed = joinPoint.proceed();
        log.info("do around after");
        return proceed;
    }
}
