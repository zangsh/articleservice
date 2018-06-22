package com.czb.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.czb.article.bean.po.Label;
import com.czb.article.bean.vo.LabelArticleVo;
import com.czb.article.bean.vo.LabelVo;
import com.czb.article.dao.LabelMapper;
import com.czb.article.service.LabelService;
import com.czb.article.util.MyIdFactory;
import com.czb.article.util.ResultUtils;
import com.czb.enums.ResultCode;
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
			ResultUtils.ERROR(ResultCode.EXIST_OBJ);
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
			ResultUtils.ERROR(ResultCode.NOT_EXIST_OBJ);
		}
		//判断是否重复
		Label temp = labelMapper.selectByName(label.getName());
		if(temp!=null){
			if(!label.getId().equals(temp.getId())){
				ResultUtils.ERROR(ResultCode.EXIST_OBJ);
			}
		}
		//判断是否存在文章
		Integer labelArticleCount = labelMapper.selectLabelArticleCount(label.getId());
		if(labelArticleCount!=null && labelArticleCount>0){
			ResultUtils.ERROR(ResultCode.EXIST_RELATION_OBJ);
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

	@Override
	public String deleteById(String id) {
		if(StringUtils.isEmpty(id)){
			ResultUtils.ERROR(ResultCode.NOT_EXIST_OBJ);
		}
		//判断是否存在文章
		Integer labelArticleCount = labelMapper.selectLabelArticleCount(id);
		if(labelArticleCount!=null && labelArticleCount>0){
			ResultUtils.ERROR(ResultCode.EXIST_RELATION_OBJ);
		}
		labelMapper.deleteByPrimaryKey(id);
		return ResultUtils.OK();
	}

	@Override
	public Page<LabelArticleVo> selectLabelArticlePageForPc(String id, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
        return labelMapper.selectLabelArticlePageForPc(id);
	}

	@Override
	public Page<LabelArticleVo> selectLabelArticlePageForApp(String id, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
        return labelMapper.selectLabelArticlePageForApp(id);
	}

}
