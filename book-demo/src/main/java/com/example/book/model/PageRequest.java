package com.example.book.model;

import lombok.Data;

@Data
public class PageRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;//一页的长度
    private Integer offset;

    public Integer getOffset() {
        return (pageNum - 1) * pageSize;
    }
}
