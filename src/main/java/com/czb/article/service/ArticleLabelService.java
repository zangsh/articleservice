package com.czb.article.service;

import java.util.List;

import com.czb.article.bean.po.ArticleLabel;

/**
 * <p>Title: ArticleLabelService.java</p>
 * <p>Description: 文章标签service</p>
 * @author zhxun
 * @date 2018年6月21日下午3:27:24
 */
public interface ArticleLabelService {

	/**分页查询文章标签*/
    List<ArticleLabel> selectPage(String name,int pageNum,int pageSize);
    
    /**随机查询文章标签*/
    List<ArticleLabel> selectRandom(int size);
}
