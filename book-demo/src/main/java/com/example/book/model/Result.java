package com.example.book.model;

import com.example.book.enums.ResultStatus;
import lombok.Data;

@Data
public class Result<T> {
    private ResultStatus code;//业务码 不是HTTP状态码
    private String errMsg;//返回错误信息
    private T data;

    public static <T> Result success(T data) {
        Result result = new Result();
        result.setCode(ResultStatus.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result nologin() {
        Result result = new Result();
        result.setCode(ResultStatus.NOLOGIN);
        result.setErrMsg("用户未登录");
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setCode(ResultStatus.FAIL);
        result.setErrMsg(msg);
        return result;
    }
}
