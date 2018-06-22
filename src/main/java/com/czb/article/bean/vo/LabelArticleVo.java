package com.czb.article.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: LabelArticleVo.java</p>
 * <p>Description: 标签下文章列表</p>
 * @author zhxun
 * @date 2018年6月22日下午1:54:55
 */
public class LabelArticleVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7559790834581331814L;
	
	/**标签ID*/
    private String labelId;

    /**文章ID*/
    private String articleId;
    
    /**文章标题*/
    private String title;

    /**文章摘要*/
    private String digest;

    /**封面图片地址*/
    private String imageAddr;

    /**关键词*/
    private String keywords;
    
    /**上线时间*/
    private Date goLiveTime;

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getImageAddr() {
		return imageAddr;
	}

	public void setImageAddr(String imageAddr) {
		this.imageAddr = imageAddr;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Date getGoLiveTime() {
		return goLiveTime;
	}

	public void setGoLiveTime(Date goLiveTime) {
		this.goLiveTime = goLiveTime;
	}
    
}
