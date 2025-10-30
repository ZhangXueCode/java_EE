package com.example.book.mapper;

import com.example.book.model.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void insert() {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("1");
        bookInfo.setAuthor("1");
        bookInfo.setCount(12);
        bookInfo.setPrice(BigDecimal.valueOf(12.00));
        bookInfo.setPublish("1");
        bookInfo.setStatus(1);
        System.out.println(bookMapper.insert(bookInfo));

    }
}