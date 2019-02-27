package com.example.writereadmysql.datasource;

import com.example.writereadmysql.annotations.CustomerDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    /**
     * 切点
     */
    @Pointcut("@annotation(com.example.writereadmysql.annotations.CustomerDataSource)")
    public void aspect(){
    }

    /**
     * 切入
     * @param point
     */
    @Before("aspect()")
    private void before(JoinPoint point){

        //获取切入方法的入参
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();

        //获取切入类xxxService之类的
        Class<?> clazz = point.getTarget().getClass();
        //获取切入方法 xxxService 中的 xxx方法名称
        String method = point.getSignature().getName();
        try {
            //获取切入方法
            Method m = clazz.getMethod(method, parameterTypes);
            //判断方法是否为空,或者是否加了指定注解
            if(null != m && m.isAnnotationPresent(CustomerDataSource.class)){
                //获取注解标记数据源名称
                CustomerDataSource dataSource = m.getAnnotation(CustomerDataSource.class);

                //放入数据源名称
                JdbcContextHolder.putDataSource(dataSource.value().getName());
            }
        } catch (Exception e) {
            LOGGER.error("动态数据源切换异常",e);
        }
    }

    @After("aspect()")
    public void after(){
        JdbcContextHolder.cleanDataSource();
        LOGGER.info("数据源使用完毕,移除");
    }

}
