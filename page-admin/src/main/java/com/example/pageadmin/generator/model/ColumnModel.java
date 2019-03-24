package com.example.pageadmin.generator.model;

/**
 * 数据库字段封装
 */
public class ColumnModel {

    //数据库字段
    private String name;

    //数据库字段类型
    private String type;

    //数据库字段首字母去掉大小写
    private String changeNameToCamel;

    //数据库字段注释
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChangeNameToCamel() {
        return changeNameToCamel;
    }

    public void setChangeNameToCamel(String changeNameToCamel) {
        this.changeNameToCamel = changeNameToCamel;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
