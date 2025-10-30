package com.example.book.service;

import com.example.book.dao.BookDao;
import com.example.book.enums.BookStatus;
import com.example.book.mapper.BookMapper;
import com.example.book.model.BookInfo;
import com.example.book.model.PageRequest;
import com.example.book.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 添加图书
     * @param bookInfo
     * @return
     */
    public Integer addBook(BookInfo bookInfo) {
        return bookMapper.insert(bookInfo);
    }

    /**
     * 通过分页操作获得list
     * @param pageRequest
     * @return
     */
    public PageResult<BookInfo> getListByPage(PageRequest pageRequest) {
        Integer count = bookMapper.count();
        List<BookInfo> bookInfos = bookMapper.selectByPage(pageRequest.getOffset(), pageRequest.getPageSize());
        for(BookInfo bookInfo : bookInfos) {
            bookInfo.setStatusCN(BookStatus.getDescByCode(bookInfo.getStatus()).getDesc());
        }
        return new PageResult(count,bookInfos,pageRequest);
    }

    /**
     * 查询图书
     * @param bookId
     * @return
     */
    public BookInfo selectById(Integer bookId) {
        BookInfo bookInfo = bookMapper.selectById(bookId);
        bookInfo.setStatusCN(BookStatus.getDescByCode(bookInfo.getStatus()).getDesc());
        return bookInfo;
    }

    /**
     * 修改图书
     * @param
     * @return
     */
    public Integer updateById(BookInfo bookInfo) {
        return bookMapper.updateById(bookInfo);

    }

    /**
     * 删除
     * @param bookId
     * @return
     */

    public Integer deleteBook(Integer bookId) {
        return bookMapper.deleteBook(bookId);
    }

    /**
     * 批量删除
     */

    public Integer batchDelete(List<Integer> ids) {
        return bookMapper.batchDelete(ids);
    }








}
