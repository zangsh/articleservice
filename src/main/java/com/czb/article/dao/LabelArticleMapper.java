package com.czb.article.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 文章和标签关联
 */
public interface LabelArticleMapper {

    /**
     * 新增文章标签
     * @param labelId 标签ID
     * @param articleId 文章ID
     */
    void addLabelArticle(@Param("labelId") Long labelId, @Param("articleId") Long articleId);

}