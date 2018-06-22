package com.czb.article.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.czb.article.bean.po.Label;
import com.czb.article.bean.vo.LabelArticleVo;
import com.czb.article.bean.vo.LabelVo;
import com.github.pagehelper.Page;

/**
 * <p>Title: LabelMapper.java</p>
 * <p>Description: 标签dao</p>
 * @author zhxun
 * @date 2018年6月21日下午3:20:26
 */
public interface LabelMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    Label selectByPrimaryKey(Integer id);

    List<LabelVo> selectAll();

    int updateByPrimaryKey(Label record);
    
    Page<LabelVo> selectPage(@Param("name") String name);
    
    List<LabelVo> selectRandom(int size);
    
    Label selectByName(String name);
    
    Integer selectLabelArticleCount(Integer id);
    
    Page<LabelArticleVo> selectLabelArticlePageForPc(Integer id);
    
    Page<LabelArticleVo> selectLabelArticlePageForApp(Integer id);
}