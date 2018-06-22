package com.czb.article.service.impl;

import com.czb.article.bean.vo.ArticleResponse;
import com.czb.article.dao.ArticleMapper;
import com.czb.article.service.ArticleService;
import com.czb.article.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zangsh on 2018/6/21.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int isExistsTitle(Map<String, Object> params) {
        return articleMapper.isExistsTitle(params);
    }

    @Override
    public int addArticle(Map<String, Object> params) {
        return articleMapper.addArticle(params);
    }

    @Override
    public List<ArticleResponse> getArticleByPage(Map<String, Object> params) {
        Integer pageNum = Integer.parseInt(params.get("pageNum").toString());
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        return articleMapper.getArticleByPage(params,pageNum,pageSize);
    }
}
