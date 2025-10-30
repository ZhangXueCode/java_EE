package com.example.demo.service;

import com.example.demo.mapper.PublishMapper;
import com.example.demo.model.MessageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {
    @Autowired
    private PublishMapper publishMapper;
    public Integer publish(MessageInfo messageInfo) {
        Integer result = publishMapper.publish(messageInfo);
        return result;
    }

}
