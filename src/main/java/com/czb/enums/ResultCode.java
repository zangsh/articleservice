package com.czb.enums;

/**
 * 返回状态码和信息定义
 * code:6位数字（400 开头客户端错误；500 开头服务端错误）
 * Created by zangsh on 2018/6/22.
 */
public enum  ResultCode {
    EXIST_OBJ(400001,"信息已存在！");

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
