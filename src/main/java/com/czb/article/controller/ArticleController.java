package com.czb.article.controller;

import com.czb.article.bean.vo.ArticleResponse;
import com.czb.article.service.ArticleService;
import com.czb.article.util.FastJsonUtils;
import com.czb.article.util.ResultUtils;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zangsh on 2018/6/21.
 */
@Slf4j
@RestController
@RequestMapping(value = "/article",method = RequestMethod.POST)
public class ArticleController {
    @Autowired
    private ArticleService articleService;

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
     *                    "keywords":"xxx"，
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
        log.info("addArticle参数：" + json);
        Map<String,Object> params = FastJsonUtils.stringToMap(json);
        if(!StringUtils.isEmpty(params.get("token"))){
            params.put("create_user","1");
            params.put("update_user","1");
        }
        try {
            articleService.addArticle(params);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResultUtils.ERROR(e.getMessage());
        }
        return ResultUtils.OK();
    }

    /**
     * @api {post} /article/getArticleByPage 获取文章列表 getArticleByPage
     * @apiName 获取文章列表
     * @apiGroup article-interface
     * @apiVersion 0.0.1
     * @apiDescription 官网后台新增文章
     * @apiParam {String} token 用户token
     * @apiParam {String} pageNum 分页编号
     * @apiParam {String} pageSize 分页大小
     * @apiParamExample {json} 请求样例：
     *                {
     *                    "token":"xxx",
     *                    "pageNum":"xxx",
     *                    "pageSize":"xxx"
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
    @RequestMapping(value = "/getArticleByPage")
    public String getArticleByPage(@RequestBody String json){
        log.info("addArticle参数：" + json);
        Map<String,Object> params = FastJsonUtils.stringToMap(json);
        List<ArticleResponse> articleResponseList = articleService.getArticleByPage(params);
        return ResultUtils.OK(new PageInfo<>(articleResponseList));
    }
}
