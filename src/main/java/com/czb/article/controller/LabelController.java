package com.czb.article.controller;

import com.czb.article.bean.po.Label;
import com.czb.article.service.LabelService;
import com.czb.article.util.ResultUtils;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Title: LabelController.java</p>
 * <p>Description: 标签controller</p>
 * @author zhxun
 * @date 2018年6月21日下午3:39:31
 */
@RestController
@RequestMapping(value = "/label")
public class LabelController {
	
	@Autowired
	private LabelService labelService;

    /**
     * @api {get} /articleLabel/getLabels 查询标签分页
     * @apiName 查询标签分页
     * @apiGroup label-interface
     * @apiVersion 0.0.1
     * @apiDescription 查询标签分页
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
    @RequestMapping(value = "/getLabels", method = {RequestMethod.GET})
    public String getLabels(String name,@RequestParam(required=false,defaultValue="1")int pageNum,
    		@RequestParam(required=false,defaultValue="10")int pageSize){
    	List<Label> list = labelService.selectPage(name, pageNum, pageSize);
    	PageInfo pageInfo = new PageInfo(list);
        return ResultUtils.OK(pageInfo);
    }
    
    /**
     * @api {get} /articleLabel/getRandomLabels 随机查询标签
     * @apiName 随机查询标签
     * @apiGroup label-interface
     * @apiVersion 0.0.1
     * @apiDescription 随机查询标签
 	 * @apiParam {int} size 长度
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功 5xxxxx 错误
     * @apiSuccess (200) {String} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":[
     *          	{
	 *		            "createTime": 1529569122000,
	 *		            "createUser": "",
	 *		            "deleteFlag": false,
	 *		            "id": "1",
	 *		            "name": "生活",
	 *		            "type": 1,
	 *		            "updateTime": 1529569124000,
	 *		            "updateUser": ""
	 *		        }
     *          ]
     * 		}
     */
	@CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getRandomLabels", method = {RequestMethod.GET})
    public String getRandomLabels(@RequestParam(required=false,defaultValue="10")int size){
    	List<Label> list = labelService.selectRandom(size);
        return ResultUtils.OK(list);
    }
}
