package com.example.book.enums;

public enum ResultStatus {
    SUCCESS(200),
    FAIL(-1),
    NOLOGIN(-2),
    ;
    private int code;

    ResultStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
