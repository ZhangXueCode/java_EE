package com.example.readyml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read")
public class Read {
    @Value("${a}")
    private int a;
    @Value("${string.str}")
    private String string;
    @Value("${student.id}")
    private Integer id;

    @Autowired
    private Student student;

    @RequestMapping("/yml")
    public String get() {
        return "配置: " + a;
    }
    @RequestMapping("/yml2")
    public String get2() {
        return "配置: " + student;
    }
    @RequestMapping("/yml3")
    public String get3() {
        return "配置: " + string;
    }
    @RequestMapping("/yml4")
    public String get4() {
        return "配置: " + id;
    }

}
