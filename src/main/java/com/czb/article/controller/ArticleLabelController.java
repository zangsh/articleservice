package com.czb.article.controller;

import com.czb.article.bean.po.ArticleLabel;
import com.czb.article.service.ArticleLabelService;
import com.czb.article.util.ResultUtils;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Title: ArticleLabelController.java</p>
 * <p>Description: 文章标签controller</p>
 * @author zhxun
 * @date 2018年6月21日下午3:39:31
 */
@RestController
@RequestMapping(value = "/articleLabel")
public class ArticleLabelController {
	
	@Autowired
	private ArticleLabelService articleLabelService;

    /**
     * @api {post} /articleLabel/getArticleLabels 查询文章标签分页
     * @apiName 查询文章标签分页
     * @apiGroup articleLabel-interface
     * @apiVersion 0.0.1
     * @apiDescription 查询文章标签分页
     * @apiParam {String} name 标签名称
 	 * @apiParam {int} pageNum 页码
 	 * @apiParam {int} pageSize 每页长度
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功 5xxxxx 错误
     * @apiSuccess (200) {String} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":{}
     * 		}
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getArticleLabels")
    public String getArticleLabels(String name,@RequestParam(required=false,defaultValue="1")int pageNum,
    		@RequestParam(required=false,defaultValue="10")int pageSize){
    	List<ArticleLabel> list = articleLabelService.selectPage(name, pageNum, pageSize);
    	PageInfo pageInfo = new PageInfo(list);
        return ResultUtils.OK(pageInfo);
    }
    
    /**
     * @api {post} /articleLabel/getRandomArticleLabels 随机查询文章标签
     * @apiName 查询文章标签分页
     * @apiGroup articleLabel-interface
     * @apiVersion 0.0.1
     * @apiDescription 随机查询文章标签
 	 * @apiParam {int} size 长度
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功 5xxxxx 错误
     * @apiSuccess (200) {String} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":{}
     * 		}
     */
	@CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getRandomArticleLabels")
    public String getRandomArticleLabels(@RequestParam(required=false,defaultValue="10")int size){
    	List<ArticleLabel> list = articleLabelService.selectRandom(size);
        return ResultUtils.OK(list);
    }
}
