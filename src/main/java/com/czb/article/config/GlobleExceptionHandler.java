package com.czb.article.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czb.article.util.ResultUtils;

@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobleExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandle(Exception e) {
        logger.error(" 出现错误：{}", e);
        return ResultUtils.ERROR(e.getMessage());
    }
}
