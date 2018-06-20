package com.czb.article.bean.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private Date birthday;

    private String name1;

    private String xx;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx == null ? null : xx.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", birthday=").append(birthday);
        sb.append(", name1=").append(name1);
        sb.append(", xx=").append(xx);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}