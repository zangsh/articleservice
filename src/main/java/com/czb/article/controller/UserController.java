package com.czb.article.controller;

import com.czb.article.bean.po.User;
import com.czb.article.service.UserService;
import com.czb.article.util.ResultUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by zangsh on 2018/6/20.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public Map getUser(){
        List<User> userList = userService.getUserByNumSize(2,2);
        PageInfo pageInfo = new PageInfo(userList);

        System.out.print(pageInfo.getTotal());
        return ResultUtils.OK(pageInfo);
    }
}
