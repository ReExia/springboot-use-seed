package com.example.pageadmin.constant;

public enum  MsgSignFlagEnum {

    UN_SIGNED(0, "未签收"),
    SIGNED(1, "已签收");

    public int code;
    public String msg;

    MsgSignFlagEnum(int code, String msg){
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
