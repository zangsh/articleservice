package com.czb.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czb.article.bean.po.ArticleLabel;
import com.czb.article.dao.ArticleLabelMapper;
import com.czb.article.service.ArticleLabelService;

/**
 * <p>Title: ArticleLabelServiceImpl.java</p>
 * <p>Description: 文章标签service实现类</p>
 * @author zhxun
 * @date 2018年6月21日下午3:32:24
 */
@Service
public class ArticleLabelServiceImpl implements ArticleLabelService{
    @Autowired
    private ArticleLabelMapper articleLabelMapper;

    @Override
    public List<ArticleLabel> selectPage(String name,int pageNum,int pageSize) {
        return articleLabelMapper.selectPage(name,pageNum,pageSize);
    }

	@Override
	public List<ArticleLabel> selectRandom(int size) {
		return articleLabelMapper.selectRandom(size);
	}
}
