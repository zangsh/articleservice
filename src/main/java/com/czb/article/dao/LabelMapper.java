package com.czb.article.dao;

import com.czb.article.bean.po.Label;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * <p>Title: LabelMapper.java</p>
 * <p>Description: 标签dao</p>
 * @author zhxun
 * @date 2018年6月21日下午3:20:26
 */
public interface LabelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Label record);

    Label selectByPrimaryKey(String id);

    List<Label> selectAll();

    int updateByPrimaryKey(Label record);
    
    List<Label> selectPage(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);
    
    List<Label> selectRandom(int size);
}