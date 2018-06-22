package com.czb.article.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classifyController")
public class ClassifyController {
	private Logger logger = Logger.getLogger(this.getClass());

	/**
     * @api {post} /article/queryAllClassify 
     * @apiName 查询所有文章分类
     * @apiGroup article-interface
     * @apiVersion 0.0.1
     * @apiDescription 官网后台新增文章
     * @apiParam {String} token 用户token
     * @apiParam {String} title 用户标题
     * @apiParam {String} content 文章内容
     * @apiParam {String} digest 文章摘要
     * @apiParam {String} image_addr 封面图片地址
     * @apiParam {String} keywords 关键词（逗号分隔，）
     * @apiParamExample {json} 请求样例：
     *                {
     *                    "token":"xxx",
     *                    "title":"xxx",
     *                    "content":"xxx",
     *                    "digest":"xxx",
     *                    "image_addr":"xxx",
     *                    "keywords":"xxx"
     *                }
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功 5xxxxx 错误
     * @apiSuccess (200) {String} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                {
     *                "code":"200",
     *                "msg":"操作成功",
     *                "data":{
     *
     *                }
     *                }
     */
	@RequestMapping("queryAllClassify")
	public String queryAllClassify() {

		return null;
	}

	@RequestMapping("addClassify")
	public String addClassify() {

		return null;
	}

	@RequestMapping("updateClassify")
	public String updateClassify() {

		return null;
	}

	@RequestMapping("deleteClassify")
	public String deleteClassify() {

		return null;
	}

}
