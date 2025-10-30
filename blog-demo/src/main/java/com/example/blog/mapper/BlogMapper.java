package com.example.blog.mapper;

import com.example.blog.model.BlogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapper {
    @Select("select * from blog_info where delete_flag = 0")
    List<BlogInfo> selectAll();


    @Select("select * from blog_info where delete_flag = 0 and id = #{id}")
    BlogInfo selectById(Integer id);

    Integer update(BlogInfo blogInfo);


    @Insert("insert into blog_info (title,content,user_id) values (#{title},#{content},#{userId})")
    Integer insert(BlogInfo blogInfo);
}
