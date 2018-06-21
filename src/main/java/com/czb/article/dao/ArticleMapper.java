package com.czb.article.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ArticleMapper {
    /**
     * 添加文章
     * @param params
     * @return
     */
    int addArticle(@Param("params") Map<String,Object> params);
}