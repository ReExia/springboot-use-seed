package com.example.writereadmysql.datasource;

public class JdbcContextHolder {

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    /**
     * 放入数据源
     * @param name
     */
    public static void putDataSource(String name){
        local.set(name);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSource(){
        return local.get();
    }

    /**
     * 清除数据源
     */
    public static void cleanDataSource(){
        local.remove();
    }

}
