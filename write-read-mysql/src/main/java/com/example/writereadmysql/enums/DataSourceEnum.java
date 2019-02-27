package com.example.writereadmysql.enums;

public enum  DataSourceEnum {

    USER_MASTER("user-master"),
    USER_SLAVE("user-slave")
    ;

    private String name;

    DataSourceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
