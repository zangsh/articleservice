package com.czb.article.service;

import com.czb.article.bean.po.User;

import java.util.List;

/**
 * Created by zangsh on 2018/6/20.
 */
public interface UserService {

    List<User> getUserByNumSize(int pageNum, int pageSize);
}
