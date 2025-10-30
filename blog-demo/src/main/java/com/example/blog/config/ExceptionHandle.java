package com.example.blog.config;


import com.example.blog.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    @ExceptionHandler
    public Result handle(Exception e) {
        return Result.fail("内部错误，联系管理员");
    }

}
