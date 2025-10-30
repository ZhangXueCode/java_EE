package com.example.book.model;

import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {
    private Integer id;
    //书名
    private String bookName;
    //作者
    private String author;
    //数量
    private Integer count;
    //定价
    private BigDecimal price;
    //出版社
    private String publish;
    //状态 0-⽆效 1-允许借阅 2-不允许借阅
    private Integer status;
    private String statusCN;
    private Date createTime;
    private Date updateTime;

}
