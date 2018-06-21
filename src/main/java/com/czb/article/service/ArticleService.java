package com.czb.article.service;

import com.czb.article.bean.vo.ArticleResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by zangsh on 2018/6/21.
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param params
     * @return
     */
    int addArticle(Map<String,Object> params);

    /**
     * 获取文章列表
     * @param params
     * @return
     */
    List<ArticleResponse> getArticleByPage(Map<String,Object> params);
}
