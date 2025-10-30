package com.example.book.enums;

public enum BookStatus {
    DELETE(0,"删除"),
    NORMAL(1,"可借阅"),
    FORBIDDEN(2,"不可借阅"),
    ;
    private Integer code;
    private String desc;

    BookStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static BookStatus getDescByCode(Integer code) {
        switch (code) {
            case 0: return DELETE;
            case 1: return NORMAL;
            default: return FORBIDDEN;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
