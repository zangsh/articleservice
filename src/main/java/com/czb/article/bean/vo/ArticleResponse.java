package com.czb.article.bean.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zangsh on 2018/6/21.
 */
/**
 * @apiDefine 	  ArticleResponse 		文章对象
 * @apiSuccess   (Article)    {String} id 					文章ID
 * @apiSuccess   (Article)    {String} title  		文章标题
 * @apiSuccess   (Article)    {String} digest 				文章摘要
 * @apiSuccess   (Article)    {String} imageAddr  	封面图片地址
 * @apiSuccess   (Article)    {String} keywords  		关键词
 * @apiSuccess   (Article)    {Date} createTime  		创建时间
 * @apiSuccess   (Article)    {String} content  		文章内容详细信息
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
