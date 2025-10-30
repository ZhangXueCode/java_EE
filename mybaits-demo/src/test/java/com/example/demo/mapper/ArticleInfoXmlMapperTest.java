package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleInfoXmlMapperTest {
    @Autowired
    private ArticleInfoXmlMapper articleInfoXmlMapper;
    @Test
    void select() {
        System.out.println(articleInfoXmlMapper.select());
    }
}