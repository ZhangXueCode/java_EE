package com.example.demo;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    @RequestMapping("/r1")
    public String r1(Integer age) {
        return "age:" + age;
    }
    @RequestMapping("/r2")
    public String r2(String name) {
        return "name:" + name;
    }
    @RequestMapping("/r3")
    public String r3(Student student) {
        return "student:" + student;
    }
    @RequestMapping("/r4")
    public String r4(int age) {
        return "age:" + age;
    }
    @RequestMapping("/r5")
    public String r5(@RequestParam("userName") String userName) {
        return "name:" + userName;
    }




}
