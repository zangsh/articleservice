package com.czb.article.dao;

import com.czb.article.bean.po.ArticleLabel;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * <p>Title: ArticleLabelMapper.java</p>
 * <p>Description: 文章标签dao</p>
 * @author zhxun
 * @date 2018年6月21日下午3:20:26
 */
public interface ArticleLabelMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleLabel record);

    ArticleLabel selectByPrimaryKey(String id);

    List<ArticleLabel> selectAll();

    int updateByPrimaryKey(ArticleLabel record);
    
    List<ArticleLabel> selectPage(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);
    
    List<ArticleLabel> selectRandom(int size);
}