package com.example.demo;

import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/sayHi")
    public String hello() {
        return "Hello Spring";
    }
}
