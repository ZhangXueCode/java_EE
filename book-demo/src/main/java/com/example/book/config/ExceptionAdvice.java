package com.example.book.config;

import com.example.book.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public Result exception(Exception e) {
        log.error("e:" + e);
        return Result.fail("内部错误");
    }
    @ExceptionHandler
    public Result exception(NullPointerException e) {
        log.error("e:" + e);
        return Result.fail("空指针异常");
    }
}
