package com.czb.article.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.czb.article.bean.vo.ArticleResponse;
import com.czb.article.dao.ArticleMapper;
import com.czb.article.dao.LabelArticleMapper;
import com.czb.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by zangsh on 2018/6/21.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private LabelArticleMapper labelArticleMapper;

    @Override
    public int isExistsTitle(Map<String, Object> params) {
        return articleMapper.isExistsTitle(params);
    }

    @Transactional
    @Override
    public void addArticle(Map<String, Object> params) {
        articleMapper.addArticle(params);
        Long articleId = (Long) params.get("id");
        //添加文章标签
        JSONArray array = (JSONArray) params.get("label_id");
        List<String> labelIds = JSONObject.parseArray(array.toJSONString(), String.class);
        labelIds.forEach((labelId) -> {
            labelArticleMapper.addLabelArticle(Long.parseLong(labelId), articleId);
        });
    }

    @Override
    public List<ArticleResponse> getArticleByPage(Map<String, Object> params) {
        Integer pageNum = Integer.parseInt(params.get("pageNum").toString());
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        return articleMapper.getArticleByPage(params, pageNum, pageSize);
    }
}
