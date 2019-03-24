package com.example.pageadmin.generator;

import com.example.pageadmin.generator.model.ColumnModel;
import com.example.pageadmin.generator.model.GeneratorJavaModel;
import com.mysql.jdbc.Connection;
import freemarker.template.Template;
import org.apache.commons.codec.Charsets;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.DatabaseMetaData;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratorHelper {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/user?useSSL=true";

    private static final String USER = "root";

    private static final String PASSWORD = "123";

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String tableName = "user";

    public static final Connection getConnection() throws Exception {
        return DataBaseHelper.getConnection(URL, USER, PASSWORD, DRIVER);
    }

    public static void ggenerate(String tableName) throws Exception{

        Connection connection = getConnection();
        DatabaseMetaData metaData = connection.getMetaData();

        List<ColumnModel> columnList = TableHelper.getColumnInfo(tableName, connection);

        //生成实体类

        
        //todo 生成list页面
        //todo 生成edit页面
        //todo 生成add页面

    }

    private static void generateEntity(String packageName, String author,
                                       String tableName,Connection connection,
                                       String templatePath,
                                       File file) throws Exception {

        GeneratorJavaModel generatorJavaModel = new GeneratorJavaModel();

        Template template = FreeMarkerHelper.getTemplate(templatePath);
        FileOutputStream fos = new FileOutputStream(file);

        Map<String, Object> templateMap = TableHelper.getTemplateMap(packageName, author, tableName, connection);

        Writer out = new BufferedWriter(new OutputStreamWriter(fos, Charsets.UTF_8.name()), 10204);
        template.process(templateMap, out);
    }

    public static void main(String[] args) throws Exception {
        String path = "D:/TestEntity.java";
        String templatePath = "/model/entity.ftl";
        File file = new File(path);
        generateEntity("com.example.pageadmin.generator","liuhao","user",getConnection(),templatePath,file);
    }




}
