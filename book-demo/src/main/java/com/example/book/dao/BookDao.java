package com.example.book.dao;

import com.example.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class BookDao {
    public List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("书籍" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setCount(i * 5 + 3);
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社" + i);
            if(i % 2 == 0) {
                bookInfo.setStatus(1);
            }else {
                bookInfo.setStatus(2);
            }
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
