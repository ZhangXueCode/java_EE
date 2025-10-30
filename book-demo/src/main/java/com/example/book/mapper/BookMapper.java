package com.example.book.mapper;

import com.example.book.model.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.beans.BeanInfo;
import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("insert into book_info (book_name,author,count,price,publish,`status`) " +
            "values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer insert(BookInfo bookInfo);

    @Select("select * from book_info where status != 0 order by id limit #{offset},#{limit}")
    List<BookInfo> selectByPage(Integer offset,Integer limit);

    @Select("select count(1) from book_info where status != 0")
    Integer count();

    @Select("select * from book_info where id = #{bookId}")
    BookInfo selectById(Integer bookId);

    Integer updateById(BookInfo bookInfo);

    Integer deleteBook(Integer bookId);

    Integer batchDelete(List<Integer> ids);
}
