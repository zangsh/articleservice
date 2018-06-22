package com.czb.article.controller;

import com.czb.article.bean.vo.ArticleResponse;
import com.czb.article.service.ArticleService;
import com.czb.article.util.FastJsonUtils;
import com.czb.article.util.ResultUtils;
import com.czb.enums.ResultCode;
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
     * @apiParam {String} keywords 关键词（json数组）
     * @apiParam {String} label_id 文章标签（json数组）
     * @apiParamExample {json} 请求样例：
     *                {
     *                    "token":"xxx",
     *                    "title":"xxx",
     *                    "content":"xxx",
     *                    "digest":"xxx",
     *                    "image_addr":"xxx",
     *                    "keywords":[
     *                      "专注力","思维力"
     *                    ]，
     *                    "label_ids":[
     *                      "1","2"
     *                    ]
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
    @RequestMapping(value = "/addArticle")
    public Map addArticle(@RequestBody String json){
        log.info("addArticle参数：" + json);
        Map<String,Object> params = FastJsonUtils.stringToMap(json);
        if(!StringUtils.isEmpty(params.get("token"))){
            params.put("create_user","1");
            params.put("update_user","1");
        }
        try {
            //校验文章标题是否存在
            int count = articleService.isExistsTitle(params);
            if (count > 0){
                return ResultUtils.ERROR(ResultCode.EXIST_OBJ);
            }
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
     * @apiSuccess (200) {String} data.pages 总页数
     * @apiSuccess (200) {String} data.total 总条数
     * @apiSuccess (200) {Article} data.list 数据列表
     * @apiUse ArticleResponse
     * @apiSuccessExample {json} 返回样例:
     *              {
     *               "msg": "操作成功！",
     *               "code": 200,
     *               "data": {
     *               "list": [
     *               {
     *               "content": "测试测试1111",
     *               "createTime": "2018-06-21 17:14:53",
     *               "digest": "测试2222",
     *               "id": 1,
     *               "imageAddr": "https://localhost:8080/article/addArticle",
     *               "keywords": "测试，你好，时间",
     *               "title": "测试"
     *               },
     *               {
     *               "content": "测试测试1111",
     *               "createTime": "2018-06-21 17:19:08",
     *               "digest": "测试2222",
     *               "id": 3,
     *               "imageAddr": "https://localhost:8080/article/addArticle",
     *               "keywords": "测试，你好，时间",
     *               "title": "测试1"
     *               }
     *               ],
     *               "pages": 4,
     *               "total": 7
     *               }
     *               }
     */
    @CrossOrigin
    @RequestMapping(value = "/getArticleByPage")
    public Map getArticleByPage(@RequestBody String json){
        log.info("addArticle参数：" + json);
        Map<String,Object> params = FastJsonUtils.stringToMap(json);
        List<ArticleResponse> articleResponseList = articleService.getArticleByPage(params);
        return ResultUtils.OK(new PageInfo<>(articleResponseList));
    }
}
