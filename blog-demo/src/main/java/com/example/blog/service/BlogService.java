package com.example.blog.service;

import com.example.blog.mapper.BlogMapper;
import com.example.blog.model.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public List<BlogInfo> selectAll() {
        return blogMapper.selectAll();
    }

    public BlogInfo selectById(Integer id) {
        return blogMapper.selectById(id);
    }

    public Integer update(BlogInfo blogInfo) {
        return blogMapper.update(blogInfo);
    }

    public Integer insert(BlogInfo blogInfo) {
        return blogMapper.insert(blogInfo);
    }


}
