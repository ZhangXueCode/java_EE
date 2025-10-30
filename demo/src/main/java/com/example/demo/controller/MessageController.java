package com.example.demo.controller;

import com.example.demo.model.MessageInfo;
import com.example.demo.service.GetService;
import com.example.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    private PublishService publishService;
    @Autowired
    private GetService getService;
    @RequestMapping("/publish")
    public Boolean publish( MessageInfo messageInfo) {
        if(!StringUtils.hasLength(messageInfo.getFrom()) || !StringUtils.hasLength(messageInfo.getTo()) || !StringUtils.hasLength(messageInfo.getMessage())) {
            return false;
        }
        int result = publishService.publish(messageInfo);
        if(result > 0) {
            return true;
        }
        return false;
    }
    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        return getService.get();
    }
}
