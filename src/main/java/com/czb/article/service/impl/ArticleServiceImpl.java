package com.czb.article.service.impl;

import com.czb.article.dao.ArticleMapper;
import com.czb.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zangsh on 2018/6/21.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public int addArticle(Map<String, Object> params) {
        return articleMapper.addArticle(params);
    }
}
