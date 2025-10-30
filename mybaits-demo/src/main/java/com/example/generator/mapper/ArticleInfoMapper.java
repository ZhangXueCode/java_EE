package com.example.generator.mapper;

import com.example.generator.model.ArticleInfo;
import java.util.List;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer id);

    List<ArticleInfo> selectAll();

    int updateByPrimaryKey(ArticleInfo record);
}