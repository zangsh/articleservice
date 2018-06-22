package com.czb.article.bean.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章分类
 * 
 * @author Abigale
 *
 */
public class Classify implements Serializable {
	private String id;

	private String classifyName;

	private Date createTime;

	private Date updateTime;

	private String createUser;

	private String updateUser;

	private Integer deleteFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Classify [id=" + id + ", classifyName=" + classifyName + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", createUser=" + createUser + ", updateUser=" + updateUser + ", deleteFlag="
				+ deleteFlag + "]";
	}

}
