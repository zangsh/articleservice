package com.czb.article.service;

import java.util.List;

import com.czb.article.bean.po.Label;

/**
 * <p>Title: LabelService.java</p>
 * <p>Description: 标签service</p>
 * @author zhxun
 * @date 2018年6月21日下午3:27:24
 */
public interface LabelService {

	/**分页查询文章标签*/
    List<Label> selectPage(String name,int pageNum,int pageSize);
    
    /**随机查询文章标签*/
    List<Label> selectRandom(int size);
}
