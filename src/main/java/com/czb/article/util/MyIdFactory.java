package com.czb.article.util;

import java.util.UUID;

/**
 * <p>Title: MyIdFactory.java</p>
 * <p>Description: uuid生成工具</p>
 * @author zhxun
 * @date 2018年6月22日上午11:03:42
 */
public class MyIdFactory {

    /**
     * 生成uuid
     *
     * @return uuid
     */
    public static String generaterId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
