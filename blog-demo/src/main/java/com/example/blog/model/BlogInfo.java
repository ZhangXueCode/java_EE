package com.example.blog.model;

import com.example.blog.utils.DateUtils;
import lombok.Data;

import java.util.Date;

@Data
public class BlogInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private boolean isLoginUser;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    public String getCreateTime() {
        return DateUtils.dateFormat(createTime);
    }
}
