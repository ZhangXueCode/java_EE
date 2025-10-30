package com.example.blog.controller;

import com.example.blog.constant.Constants;
import com.example.blog.model.BlogInfo;
import com.example.blog.service.BlogService;
import com.example.blog.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    /**
     * 返回所有博客
     * @return
     */

    @RequestMapping("/selectAll")
    public List<BlogInfo> selectAll() {
        return blogService.selectAll();
    }

    /**
     * 查询博客详情
     * @param
     * @return
     */
    @RequestMapping("/selectById")
    public BlogInfo selectById(Integer blogId, HttpServletRequest request) {
        BlogInfo blogInfo = blogService.selectById(blogId);
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        Integer userId = JwtUtils.getIdByToken(token);
        if(userId == blogInfo.getUserId()) {
            blogInfo.setLoginUser(true);
        }
        return blogInfo;

    }

    /**
     * 更新博客
     * @param blogInfo
     * @return
     */
    @RequestMapping("/update")
    public boolean update(BlogInfo blogInfo) {
        if(!StringUtils.hasLength(blogInfo.getTitle()) || !StringUtils.hasLength(blogInfo.getContent())) {
            return false;
        }
        blogService.update(blogInfo);
        return true;
    }

    /**
     * 发布博客
     * @param blogInfo
     * @return
     */
    @RequestMapping("/insert")
    public boolean insert(BlogInfo blogInfo,HttpServletRequest request) {
        if(!StringUtils.hasLength(blogInfo.getContent()) || !StringUtils.hasLength(blogInfo.getTitle())) {
            return false;
        }

        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        //从token中获取登录用户ID
        Integer userId = JwtUtils.getIdByToken(token);
        if (userId==null || userId<=0){
            return false;
        }
        blogInfo.setUserId(userId);
        blogService.insert(blogInfo);
        return true;
    }

    /**
     * 删除博客
     * @param blogId
     * @return
     */

    @RequestMapping("/delete")
    public boolean delete(Integer blogId) {
        if(blogId <= 0) {
            return false;
        }
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setDeleteFlag(1); //删除
        blogService.update(blogInfo);
        return true;
    }

}
