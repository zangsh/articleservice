package com.czb.article.util;

import java.util.HashMap;
import java.util.Map;

import com.czb.article.enums.ResultCode;

/**
 * 自定义响应
 */
public class ResultUtils {

    private static final Map<String,Object> MAP = new HashMap<>();

    private static final String CODE = "code";
    private static final int OK_CODE = 200;
    private static final int ERROR_CODE = 500000;

    private static final String MSG = "msg";
    private static final String OK_MSG = "操作成功！";
    private static final String ERROR_MSG = "操作失败！";

    private static final String DATA = "data";

    /**
     * 成功信息
     * @return
     */
    public static Map<String,Object> OK(){
        return OK(OK_MSG);
    }

    public static Map<String,Object> OK(String msg){
        return OK(OK_CODE,msg,null);
    }

    public static Map<String,Object> OK(Object data){
        return OK(OK_CODE,data);
    }

    public static Map<String,Object> OK(int code,Object data){
        return OK(code,OK_MSG,data);
    }

    public static Map<String,Object> OK(int code,String msg,Object data){
        MAP.put(CODE,code);
        MAP.put(MSG,msg);
        MAP.put(DATA,data);
        return MAP;
    }

    /**
     * 失败信息
     * @return
     */
    public static Map<String,Object> ERROR(){
        return ERROR(ERROR_MSG);
    }

    public static Map<String,Object> ERROR(String msg){
        return ERROR(ERROR_CODE,msg,null);
    }

    public static Map<String,Object> ERROR(Object data){
        return ERROR(ERROR_CODE,data);
    }

    public static Map<String,Object> ERROR(int code,Object data){
        return ERROR(code,ERROR_MSG,data);
    }

    public static Map<String,Object> ERROR(int code,String msg,Object data){
        MAP.put(CODE,code);
        MAP.put(MSG,msg);
        MAP.put(DATA,data);
        return MAP;
    }

    public static Map<String,Object> ERROR(ResultCode resultCode){
        MAP.put(CODE,resultCode.getCode());
        MAP.put(MSG,resultCode.getMsg());
        MAP.put(DATA,null);
        return MAP;
    }
}
