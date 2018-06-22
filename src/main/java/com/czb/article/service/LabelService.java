package com.czb.article.service;

import java.util.List;
import java.util.Map;

import com.czb.article.bean.po.Label;
import com.czb.article.bean.vo.LabelArticleVo;
import com.czb.article.bean.vo.LabelVo;
import com.github.pagehelper.Page;

/**
 * <p>Title: LabelService.java</p>
 * <p>Description: 标签service</p>
 * @author zhxun
 * @date 2018年6月21日下午3:27:24
 */
public interface LabelService {

	/**
     * 分页查询标签
     * name 标签名称
     * pageNum 页码
     * pageSize 数量
     * */
	Page<LabelVo> selectPage(String name,int pageNum,int pageSize);
    
    /**随机查询标签*/
    List<LabelVo> selectRandom(int size);
    
    /**添加标签*/
    Map addLabel(Label label);
    
    /**修改标签*/
    Map editLabel(Label label);
    
    /**查询所有*/
    List<LabelVo> selectAll();
    
    /**查询详细*/
    LabelVo selectById(Integer id);
    
    /**删除标签*/
    Map deleteById(Integer id);
    
    /**
     * 官网分页查询标签文章
     * id 标签id
     * pageNum 页码
     * pageSize 数量
     * */
	Page<LabelArticleVo> selectLabelArticlePageForPc(Integer id, int pageNum,int pageSize);
	
	/**
     * app分页查询标签文章
     * id 标签id
     * pageNum 页码
     * pageSize 数量
     * */
	Page<LabelArticleVo> selectLabelArticlePageForApp(Integer id, int pageNum,int pageSize);
}
