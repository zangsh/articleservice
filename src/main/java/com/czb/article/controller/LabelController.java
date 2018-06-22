package com.czb.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.czb.article.bean.po.Label;
import com.czb.article.bean.vo.LabelVo;
import com.czb.article.common.PageInfo;
import com.czb.article.common.ValidationResult;
import com.czb.article.service.LabelService;
import com.czb.article.util.ResultUtils;
import com.czb.article.util.ValidationUtils;
import com.github.pagehelper.Page;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Title: LabelController.java</p>
 * <p>Description: 标签controller</p>
 * @author zhxun
 * @date 2018年6月21日下午3:39:31
 */
@Slf4j
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
     * @apiSuccess (200) {int} code 200 成功
     * @apiSuccess (200) {String} data 返回数据
     * - pageNum:当前页
     * - pageSize:每页长度
     * - pages:总页数
     * - total:总条数
     * - list:数据列表
     * - id:标签ID
     * - name:标签名称
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":{
	 *		        "list": [
	 *		            {
	 *		                "createTime": "2018-06-21 16:18:42",
	 *		                "id": "1",
	 *		                "name": "生活",
	 *		            }
	 *		        ],
	 *		        "pageNum": 1,
	 *		        "pageSize": 10,
	 *		        "pages": 1,
	 *		        "total": 2
     *          }
     * 		}
     */
	@CrossOrigin
    @RequestMapping(value = "/getLabels", method = {RequestMethod.GET})
    public String getLabels(String name,@RequestParam(required=false,defaultValue="1")int pageNum,
    		@RequestParam(required=false,defaultValue="10")int pageSize){
    	log.info("getLabels start! name:{},pageNum:{},pageSize:{}", name,pageNum,pageSize);
    	Page<LabelVo> labelVos = labelService.selectPage(name, pageNum, pageSize);
    	PageInfo<LabelVo> pageInfo = new PageInfo<>(labelVos);
        return ResultUtils.OK(pageInfo);
    }

    /**
     * @api {get} /articleLabel/getAllLabels 查询所有标签
     * @apiName 查询所有标签
     * @apiGroup label-interface
     * @apiVersion 0.0.1
     * @apiDescription 查询所有标签
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功
     * @apiSuccess (200) {String} data 返回数据
     * - id:标签ID
     * - name:标签名称
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":[
     *          	{
	 *		            "id": "1",
	 *		            "name": "生活",
	 *		        }
     *          ]
     * 		}
     */
	@CrossOrigin
    @RequestMapping(value = "/getAllLabels", method = {RequestMethod.GET})
    public String getAllLabels(){
    	log.info("getAllLabels start!");
    	List<LabelVo> labelVos = labelService.selectAll();
        return ResultUtils.OK(labelVos);
    }
    
    /**
     * @api {get} /articleLabel/getRandomLabels 随机查询标签
     * @apiName 随机查询标签
     * @apiGroup label-interface
     * @apiVersion 0.0.1
     * @apiDescription 随机查询标签
 	 * @apiParam {int} size 长度
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功
     * @apiSuccess (200) {String} data 返回数据
     * - id:标签ID
     * - name:标签名称
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":[
     *          	{
	 *		            "id": "1",
	 *		            "name": "生活",
	 *		        }
     *          ]
     * 		}
     */
	@CrossOrigin
    @RequestMapping(value = "/getRandomLabels", method = {RequestMethod.GET})
    public String getRandomLabels(@RequestParam(required=false,defaultValue="10")int size){
		log.info("getRandomLabels start! size:{}", size);
    	List<LabelVo> list = labelService.selectRandom(size);
        return ResultUtils.OK(list);
    }
	
	/**
     * @api {post} /articleLabel/addLabel 添加标签
     * @apiName 添加标签
     * @apiGroup label-interface
     * @apiVersion 0.0.1
     * @apiDescription 添加标签
 	 * @apiParam {string} name 标签名称
 	 * @apiParamExample {json} 请求样例：
     * 		{
     *      	"name":"xxx"
     *      }
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功
     * @apiSuccess (200) {String} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":null
     * 		}
     */
	@CrossOrigin
    @RequestMapping(value = "/addLabel", method = {RequestMethod.POST})
    public String addLabel(@RequestBody Label label){
		log.info("addLabel start! label:{}", label);
		ValidationResult validationResult = ValidationUtils.validateEntity(label);
		if(validationResult.isHasErrors()){
			return ResultUtils.ERROR(validationResult.getErrorMsg());
		}
		return labelService.addLabel(label);
    }
	
	/**
     * @api {post} /articleLabel/editLabel 修改标签
     * @apiName 修改标签
     * @apiGroup label-interface
     * @apiVersion 0.0.1
     * @apiDescription 修改标签
 	 * @apiParam {string} name 标签名称
 	 * @apiParam {string} id 标签ID
 	 * @apiParamExample {json} 请求样例：
     * 		{
     *      	"name":"xxx",
     *      	"id":"xxx"
     *      }
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功
     * @apiSuccess (200) {String} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":null
     * 		}
     */
	@CrossOrigin
    @RequestMapping(value = "/editLabel", method = {RequestMethod.POST})
    public String editLabel(@RequestBody Label label){
		log.info("editLabel start! label:{}", label);
		ValidationResult validationResult = ValidationUtils.validateEntity(label);
		if(validationResult.isHasErrors()){
			return ResultUtils.ERROR(validationResult.getErrorMsg());
		}
		return labelService.editLabel(label);
    }
	
	/**
     * @api {get} /articleLabel/getLabelDetails 查询标签详细
     * @apiName 查询标签详细
     * @apiGroup label-interface
     * @apiVersion 0.0.1
     * @apiDescription 查询标签详细
 	 * @apiParam {string} id id
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 200 成功
     * @apiSuccess (200) {String} data 返回数据
     * - id:标签ID
     * - name:标签名称
     * @apiSuccessExample {json} 返回样例:
     * 		{
     * 			"code":"200",
     *          "msg":"操作成功",
     *          "data":{
	 *		            "id": "1",
	 *		            "name": "生活"
	 *		        }
     * 		}
     */
	@CrossOrigin
    @RequestMapping(value = "/getLabelDetails", method = {RequestMethod.GET})
    public String getLabelDetails(String id){
		log.info("getLabelDetails start! id:{}", id);
    	LabelVo labelVo = labelService.selectById(id);
        return ResultUtils.OK(labelVo);
    }
}
