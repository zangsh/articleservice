package com.czb.article.enums;

/**
 * 返回状态码和信息定义
 * code:6位数字（400 开头客户端错误；500 开头服务端错误）
 * Created by zangsh on 2018/6/22.
 */
public enum  ResultCode {
    EXIST_OBJ(400001,"信息已存在！"),
    NOT_EXIST_OBJ(400002,"信息不存在！"),
    EXIST_RELATION_OBJ(400003,"存在关联信息！"),
    PARAMETER_ERROR_OBJ(400004,"参数格式错误！");

    private int code;

    private String msg;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
