package com.czb.article.bean.po;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

/**
 * <p>Title: Label.java</p>
 * <p>Description: 标签</p>
 * @author zhxun
 * @date 2018年6月21日下午3:17:34
 */
public class Label implements Serializable {
	
	/**id*/
    private String id;

    /**名称*/
    @Pattern(regexp="[\u4e00-\u9fa5a-zA-Z]{2,8}",message="标签名称格式错误")
    private String name;

    /**创建人ID*/
    private String createUser;

    /**创建时间*/
    private Date createTime;

    /**修改人ID*/
    private String updateUser;

    /**修改时间*/
    private Date updateTime;

    /**删除标识0:未删除 1:已删除*/
    private Boolean deleteFlag;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}