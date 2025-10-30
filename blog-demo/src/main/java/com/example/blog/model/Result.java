package com.example.blog.model;

import com.example.blog.enums.ResultStatus;
import lombok.Data;

@Data
public class Result<T> {
    private ResultStatus code;
    private String errMsg;
    private T data;

    public static <T> Result success(T data) {
        Result result = new Result();
        result.setCode(ResultStatus.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result fail(String errMsg) {
        Result result = new Result();
        result.setCode(ResultStatus.FAIL);
        result.setErrMsg(errMsg);
        return result;
    }

    public static <T> Result fail(String errMsg,T data) {
        Result result = new Result();
        result.setCode(ResultStatus.FAIL);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }
}
