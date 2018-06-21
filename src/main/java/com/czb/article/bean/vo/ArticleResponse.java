package com.czb.article.bean.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zangsh on 2018/6/21.
 */
@Data
public class ArticleResponse implements Serializable {
    private Integer id;

    private String title;

    private String digest;

    private String imageAddr;

    private String keywords;

    private Date createTime;

    private String content;
}
