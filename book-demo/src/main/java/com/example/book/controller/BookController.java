package com.example.book.controller;

import com.example.book.model.BookInfo;
import com.example.book.model.PageRequest;
import com.example.book.model.PageResult;
import com.example.book.model.Result;
import com.example.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 添加图书
     * @param bookInfo
     * @return
     */

    @RequestMapping(value = "/addBook",produces = "application/json")
    public String addBook(BookInfo bookInfo) {
        log.info("参数为bookInfo: {}",bookInfo);
        if(!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() == null
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return "输入不合法";

        }
        try {
            Integer result = bookService.addBook(bookInfo);
            if(result > 0) {
                return "";
            }
        }catch (Exception e) {
            log.error("出现异常，e: ",e);
        }
        return "添加失败";

    }

    /**
     * 通过分页获得list
     * @param request
     * @return
     */
    @RequestMapping("/getListByPage")
    public Result<PageResult<BookInfo>> getListByPage(PageRequest request) {

        PageResult<BookInfo> bookList = bookService.getListByPage(request);
        return Result.success(bookList);
    }

    /**
     * 查询图书
     * @param bookId
     * @return
     */
    @RequestMapping("/selectById")
    public BookInfo selectById(Integer bookId) {
        return bookService.selectById(bookId);
    }

    /**
     * 修改图书
     * @param
     * @return
     */
    @RequestMapping(value = "/updateById",produces = "application/json")
    public String updateById(BookInfo bookInfo) {
        Integer result = bookService.updateById(bookInfo);
        if(result > 0) {
            return "";
        }
        return "内部错误，请联系管理";
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/deleteBook",produces = "application/json")
    public String deleteBook(Integer bookId) {
        Integer result = bookService.deleteBook(bookId);
        if(result > 0) {
            return "";
        }
        return "内部错误";
    }

    /**
     * 批量删除
     */


    @RequestMapping(value = "/batchDelete",produces = "application/json")
    public String batchDelete(@RequestParam List<Integer> ids) {
        Integer result = bookService.batchDelete(ids);
        if(result > 0) {
            return "";
        }
        return "内部错误";
    }



}
