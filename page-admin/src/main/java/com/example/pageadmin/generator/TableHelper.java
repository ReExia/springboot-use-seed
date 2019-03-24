package com.example.pageadmin.generator;

import com.example.pageadmin.generator.model.BaseTypeModel;
import com.example.pageadmin.generator.model.ColumnModel;
import com.example.pageadmin.generator.model.MysqlDataBaseTypeModel;
import com.mysql.jdbc.Connection;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.*;

public class TableHelper {

    /**
     * 替代表格下划线
     * @param value
     * @return
     */
    public static String changeStringToCamel(String value){

        //todo 校验表格名称

        StringBuilder sb = new StringBuilder();

        String[] splitArr = value.split("_");

        for (String s : splitArr) {
            String head = s.substring(0, 1);
            String remain = s.substring(1, s.length());
            sb.append(head.toUpperCase()).append(remain);
        }

        return sb.toString();
    }

    /**
     * 获取表元数据
     * @param tableName
     * @return
     * @throws Exception
     */
    public static ResultSet getTableInfo(String tableName,Connection connection) throws Exception {
        DatabaseMetaData metaData = connection.getMetaData();
        return metaData.getColumns(null, "%", tableName, "%");
    }


    /**
     * 获取表数据
     * @param tableName
     * @param connection
     * @return
     * @throws Exception
     */
    public static List<ColumnModel> getColumnInfo(String tableName, Connection connection) throws Exception {
        ResultSet resultSet = getTableInfo(tableName, connection);
        List<ColumnModel> columnList = new ArrayList<>();

        while (resultSet.next()){
            ColumnModel column = new ColumnModel();

            //获取字段名
            String name = resultSet.getString("COLUMN_NAME");
            column.setName(name);

            //获取字段类型
            String type = resultSet.getString("TYPE_NAME");
            column.setType(type);

            //数据库字段名转驼峰
            String camelName = changeStringToCamel(name);
            column.setChangeNameToCamel(camelName);

            //数据库备注
            String remarks = resultSet.getString("REMARKS");
            column.setComment(remarks);

            //添加列
            columnList.add(column);
        }
        return columnList;
    }

    public static Set<String> getBaseImportClass(List<ColumnModel> columnList){
        Set<String> importSet = new HashSet<>();
        for (ColumnModel column : columnList) {

            //基本整数类型转为Integer
            if (column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.TINYINT)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.SMALLINT)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.MEDIUMINT)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.INT)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.INTEGER)){
                importSet.add(BaseTypeModel.INTEGER);
            }

            //长整型
            if (column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.BIGINT)){
                importSet.add(BaseTypeModel.LONG);
            }

            //浮点型
            if (column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.FLOAT)){
                importSet.add(BaseTypeModel.FLOAT);
            }
            //double类型
            if (column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.DOUBLE)){
                importSet.add(BaseTypeModel.DOUBLE);
            }
            //DECIMAL类型
            if (column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.DECIMAL)){
                importSet.add(BaseTypeModel.DECIMAL);
            }

            //DATE
            if (column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.DATE)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.TIME)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.YEAR)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.DATETIME)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.TIMESTAMP)){
                importSet.add(BaseTypeModel.DATE);
            }

            //字符串类型
            if (column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.CHAR)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.VARCHAR)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.TINYBLOB)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.TINYTEXT)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.BLOB)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.TEXT)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.MEDIUMBLOB)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.MEDIUMTEXT)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.LONGBLOB)
                || column.getType().equalsIgnoreCase(MysqlDataBaseTypeModel.LONGTEXT)){
                importSet.add(BaseTypeModel.STRING);
            }
        }
        return importSet;
    }

    private static Map<String,Object> templateMap(List<ColumnModel> columnList,Set<String> importSet, String packageName, String author, String tableName){
        Map<String,Object> map = new HashMap<>();
        map.put("columnList",columnList);
        map.put("importSet",importSet);
        map.put("packageName",packageName);
        map.put("author",author);
        map.put("currentDate",new Date());
        map.put("tableName",tableName);
        return map;
    }

    /**
     * 获取生成模板需要的信息
     * @param packageName
     * @param author
     * @param tableName
     * @param connection
     * @return
     * @throws Exception
     */
    public static Map<String,Object> getTemplateMap(String packageName, String author, String tableName,Connection connection) throws Exception {
        List<ColumnModel> columnModelList = getColumnInfo(tableName, connection);
        Set<String> baseImportClass = getBaseImportClass(columnModelList);
        return templateMap(columnModelList,baseImportClass, packageName, author, tableName);
    }


}
