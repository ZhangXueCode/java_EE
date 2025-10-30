package com.example.demo.service;

import com.example.demo.mapper.GetMapper;
import com.example.demo.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetService {
    @Autowired
    private GetMapper getMapper;
    public List<MessageInfo> get() {
        return getMapper.select();
    }
}
