package com.czb.article.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: LabelVo.java</p>
 * <p>Description: 标签vo</p>
 * @author zhxun
 * @date 2018年6月21日下午7:18:59
 */
public class LabelVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6927211577192676566L;

	/**id*/
    private String id;

    /**名称*/
    private String name;

    /**创建时间*/
    private Date createTime;
    
    /**文章数量*/
    private int articleCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	
}
