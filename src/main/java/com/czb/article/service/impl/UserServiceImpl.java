package com.czb.article.service.impl;

import com.czb.article.bean.po.User;
import com.czb.article.dao.UserMapper;
import com.czb.article.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zangsh on 2018/6/20.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByNumSize(int pageNum, int pageSize) {
        return userMapper.getUserByNumSize(pageNum,pageSize);
    }
}
