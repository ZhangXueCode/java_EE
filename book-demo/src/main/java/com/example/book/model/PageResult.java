package com.example.book.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T>{
    private Integer count;
    private List<T> records;
    private PageRequest pageRequest;

    public PageResult(Integer count, List<T> records, PageRequest pageRequest) {
        this.count = count;
        this.records = records;
        this.pageRequest = pageRequest;
    }

}
