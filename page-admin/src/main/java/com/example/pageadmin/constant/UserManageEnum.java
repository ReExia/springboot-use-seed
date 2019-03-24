package com.example.pageadmin.constant;

public enum  UserManageEnum {
    ACCEPT(1,"接受"),
    IGNORE(2, "忽略")
    ;

    private int code;

    private String msg;

    UserManageEnum(int code, String msg) {
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
