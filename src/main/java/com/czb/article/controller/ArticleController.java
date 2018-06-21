package com.czb.article.controller;

import com.czb.article.util.ResultUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zangsh on 2018/6/21.
 */
@RestController
@RequestMapping(value = "/article",method = RequestMethod.POST)
public class ArticleController {

    /**
     * @api {post} /article/addArticle 新增文章 addArticle
     * @apiName 新增文章
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
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addArticle")
    public String addArticle(@RequestBody String json){
        return ResultUtils.OK();
    }
}
