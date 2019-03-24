package com.example.pageadmin.enums;


public enum UserEnum {
    // 用户激活状态
    ACTIVE(1, "已激活"),
    DISABLE(0, "未激活"),
    EMAIL_REGISTERED(300001, "邮件已经注册"),
    EMAIL_INVALID(300002, "激活邮件的连接已经过期"),
    USER_NOT_EXIST(300003, "用户不存在");

    private int code;
    private String msg;

    UserEnum(int code, String msg) {
        this.msg = msg;
        this.code = code;
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
