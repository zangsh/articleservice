package com.czb.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czb.article.bean.po.Label;
import com.czb.article.dao.LabelMapper;
import com.czb.article.service.LabelService;

/**
 * <p>Title: LabelServiceImpl.java</p>
 * <p>Description: 标签service实现类</p>
 * @author zhxun
 * @date 2018年6月21日下午3:32:24
 */
@Service
public class LabelServiceImpl implements LabelService{
    @Autowired
    private LabelMapper labelMapper;

    @Override
    public List<Label> selectPage(String name,int pageNum,int pageSize) {
        return labelMapper.selectPage(name,pageNum,pageSize);
    }

	@Override
	public List<Label> selectRandom(int size) {
		return labelMapper.selectRandom(size);
	}
}
