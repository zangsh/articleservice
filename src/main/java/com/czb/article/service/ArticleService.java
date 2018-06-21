package com.czb.article.service;

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
}
