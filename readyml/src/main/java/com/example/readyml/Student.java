package com.example.readyml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@ConfigurationProperties("student")
@Component
@Data
public class Student {
    private Integer id;
    private String name;

}
