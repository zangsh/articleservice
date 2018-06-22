package com.czb.article.dao;

import com.czb.article.bean.vo.ArticleResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    /**
     * 判断是否存在同样文章标题
     * @param params
     * @return
     */
    int isExistsTitle(@Param("params") Map<String,Object> params);

    /**
     * 添加文章
     * @param params
     * @return
     */
    int addArticle(@Param("params") Map<String,Object> params);

    /**
     * 获取文章列表
     * @param params
     * @return
     */
    List<ArticleResponse> getArticleByPage(@Param("params") Map<String,Object> params,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
}