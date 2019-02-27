package com.example.writereadmysql.datasource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.example.writereadmysql.enums.DataSourceEnum;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootConfiguration
public class DataSourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    @Qualifier("druidStatFilter")
    Filter filter;

    @Bean("userMaster")
    @Qualifier(value = "userMaster")
    @ConfigurationProperties(prefix = "spring.druid.user-master")
    public DruidDataSource dataSource1() {
        DruidDataSource dataSource = new DruidDataSource();
        // 添加慢日志功能Lists.newArrayList添加guava工具集
        dataSource.setProxyFilters(Lists.newArrayList(filter));
        LOGGER.info("数据源 user-master 初始化");
        return dataSource;
    }

    @Bean(name = "userSlave")
    @Qualifier(value = "userSlave")
    @ConfigurationProperties(prefix = "spring.druid.user-slave")
    public DataSource dataSource2(){
        DruidDataSource dataSource = new DruidDataSource();
        // 添加慢日志功能Lists.newArrayList添加guava工具集
        dataSource.setProxyFilters(Lists.newArrayList(filter));
        LOGGER.info("数据源 user-slave 初始化");
        return dataSource;
    }

    @Bean("dynamicDataSource")
    @Qualifier("dynamicDataSource")
    @Primary
    public DataSource dataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        //用户表,读写分离
        DataSource userMaster = dataSource1();
        DataSource userSlave = dataSource2();

        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(userSlave);


        //设置数据源
        Map<Object, Object> targetMap = new HashMap<>();

        targetMap.put(DataSourceEnum.USER_MASTER.getName(), userMaster);

        targetMap.put(DataSourceEnum.USER_SLAVE.getName(), userSlave);

        dynamicDataSource.setTargetDataSources(targetMap);
        return dynamicDataSource;
    }

}
