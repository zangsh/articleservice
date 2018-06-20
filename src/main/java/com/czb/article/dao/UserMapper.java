package com.czb.article.dao;

import com.czb.article.bean.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUserByNumSize(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
}