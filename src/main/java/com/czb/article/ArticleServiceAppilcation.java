package com.czb.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 文章管理服务
 * 包管理
 * constant     常量
 * controller   控制器/Restful api入口
 * dao		    持久层
 * intercepter	过滤器/拦截器
 * util	        工具类
 * service	    业务层接口
 * service.impl 业务实现层
 * enums        枚举
 * bean         实体pojo
 * config       配置
 * @author zangsh tangchen zhouxun
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@ServletComponentScan
@MapperScan("com.czb.article.dao")
public class ArticleServiceAppilcation {
    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceAppilcation.class, args);
    }
}
