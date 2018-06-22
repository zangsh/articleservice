package com.czb.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.czb.article.bean.po.Label;
import com.czb.article.bean.vo.LabelVo;
import com.czb.article.dao.LabelMapper;
import com.czb.article.service.LabelService;
import com.czb.article.util.MyIdFactory;
import com.czb.article.util.ResultUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
    public Page<LabelVo> selectPage(String name,int pageNum,int pageSize) {
    	PageHelper.startPage(pageNum, pageSize);
        return labelMapper.selectPage(name);
    }

	@Override
	public List<LabelVo> selectRandom(int size) {
		return labelMapper.selectRandom(size);
	}

	@Override
	public String addLabel(Label label) {
		//判断是否重复
		Label temp = labelMapper.selectByName(label.getName());
		if(temp!=null){
			ResultUtils.ERROR("标签已存在");
		}
		label.setId(MyIdFactory.generaterId());
		labelMapper.insert(label);
		return ResultUtils.OK();
	}

	@Override
	public List<LabelVo> selectAll() {
		return labelMapper.selectAll();
	}

	@Override
	public String editLabel(Label label) {
		if(StringUtils.isEmpty(label.getId())){
			ResultUtils.ERROR("标签ID为空");
		}
		//判断是否重复
		Label temp = labelMapper.selectByName(label.getName());
		if(temp!=null){
			if(!label.getId().equals(temp.getId())){
				ResultUtils.ERROR("标签已存在");
			}
		}
		//判断是否存在文章
		Integer labelArticleCount = labelMapper.selectLabelArticleCount(label.getId());
		if(labelArticleCount!=null && labelArticleCount>0){
			ResultUtils.ERROR("标签已绑定文章");
		}
		//更新标签
		labelMapper.updateByPrimaryKey(label);
		return ResultUtils.OK();
	}

	@Override
	public LabelVo selectById(String id) {
		if(StringUtils.isEmpty(id)){
			return null;
		}
		Label label = labelMapper.selectByPrimaryKey(id);
		LabelVo labelVo = new LabelVo();
		labelVo.setId(label.getId());
		labelVo.setName(label.getName());
		return labelVo;
	}
}
