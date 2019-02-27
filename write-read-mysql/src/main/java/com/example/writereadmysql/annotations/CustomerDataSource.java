package com.example.writereadmysql.annotations;

import com.example.writereadmysql.enums.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomerDataSource {

    DataSourceEnum value() default DataSourceEnum.USER_MASTER;
}
