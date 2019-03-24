package com.example.pageadmin.generator.model;

public class MysqlDataBaseTypeModel {

    /**********************************数值类型*****************/

    /**
     * 大小:  1 字节
     * 范围:  (-128，127)  (0，255)
     * 用途:  小整数值
     */
    public static final String TINYINT = "TINYINT";

    /**
     * 大小:	  2 字节
     * 范围:  (-32 768，32 767) (0，65 535)
     * 用途:  大整数值
     */
    public static final String SMALLINT = "SMALLINT";

    /**
     * 大小:   3 字节
     * 范围:   (-8 388 608，8 388 607)  (0，16 777 215)
     * 用途:   大整数值
     */
    public static final String MEDIUMINT = "MEDIUMINT";

    /**
     * 大小:  4 字节
     * 范围:  (-2 147 483 648，2 147 483 647)  (0，4 294 967 295)
     * 用途:  大整数值
     */
    public static final String INT = "INT";

    /**
     * 大小:  4 字节
     * 范围:  (-2 147 483 648，2 147 483 647)  (0，4 294 967 295)
     * 用途:  大整数值
     */
    public static final String INTEGER = "INTEGER";

    /**
     * 大小:  8 字节
     * 范围:  (-9,223,372,036,854,775,808，9 223 372 036 854 775 807)   (0，18 446 744 073 709 551 615)
     * 用途:  极大整数值
     */
    public static final String BIGINT = "BIGINT";

    /**
     * 大小:  4 字节
     * 范围:  (-3.402 823 466 E+38，-1.175 494 351 E-38)，0，(1.175 494 351 E-38，3.402 823 466 351 E+38)
     *        0，(1.175 494 351 E-38，3.402 823 466 E+38)
     * 用途:  单精度 浮点数值
     */
    public static final String FLOAT = "FLOAT";

    /**
     * 大小:  8 字节
     * 范围:  (-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308)
     *       0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308)
     * 用途:  双精度 浮点数值
     */
    public static final String DOUBLE = "DOUBLE";

    /**
     * 大小: 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2
     * 范围:  依赖于M和D的值
     * 用途:  小数值
     */
    public static final String DECIMAL = "DECIMAL";

    /*********************日期和时间类型**************************/

    /**
     * 大小: 3 字节
     * 范围: 1000-01-01/9999-12-31
     * 格式: YYYY-MM-DD
     * 用途: 日期值
     */
    public static final String DATE = "DATE";

    /**
     * 大小: 3 字节
     * 范围: '-838:59:59'/'838:59:59'
     * 格式: HH:MM:SS
     * 用途: 时间值或持续时间
     */
    public static final String TIME = "TIME";

    /**
     * 大小: 1 字节
     * 范围: 1901/2155
     * 格式: YYYY
     * 用途: 年份值
     */
    public static final String YEAR = "YEAR";

    /**
     * 大小: 8 字节
     * 范围: 1000-01-01 00:00:00/9999-12-31 23:59:59
     * 格式: YYYY-MM-DD HH:MM:SS
     * 用途: 混合日期和时间值
     */
    public static final String DATETIME = "DATETIME";

    /**
     * 大小: 4字节
     * 范围: 1970-01-01 00:00:00/2038 结束时间是第 2147483647 秒，北京时间 2038-1-19 11:14:07，格林尼治时间 2038年1月19日 凌晨 03:14:07
     * 格式: YYYYMMDD HHMMSS
     * 用途: 混合日期和时间值，时间戳
     */
    public static final String TIMESTAMP = "TIMESTAMP";

    /*********************字符串类型**************************/
    /**
     * 大小: 0-255字节
     * 用途: 定长字符串
     */
    public static final String CHAR = "CHAR";

    /**
     * 大小: 0-65535 字节
     * 用途: 变长字符串
     */
    public static final String VARCHAR = "VARCHAR";

    /**
     * 大小: 0-255字节
     * 用途: 不超过 255 个字符的二进制字符串
     */
    public static final String TINYBLOB = "TINYBLOB";

    /**
     * 大小: 0-255字节
     * 用途: 0-255字节
     */
    public static final String TINYTEXT = "TINYTEXT";

    /**
     * 大小: 0-65 535字节
     * 用途: 二进制形式的长文本数据
     */
    public static final String BLOB = "BLOB";

    /**
     * 大小: 0-65 535字节
     * 用途: 长文本数据
     */
    public static final String TEXT = "TEXT";

    /**
     * 大小: 0-16 777 215字节
     * 用途: 二进制形式的中等长度文本数据
     */
    public static final String MEDIUMBLOB = "MEDIUMBLOB";

    /**
     * 大小: 0-16 777 215字节
     * 用途: 中等长度文本数据
     */
    public static final String MEDIUMTEXT = "MEDIUMTEXT";

    /**
     * 大小: 0-4 294 967 295字节
     * 用途: 二进制形式的极大文本数据
     */
    public static final String LONGBLOB = "LONGBLOB";

    /**
     * 大小: 0-4 294 967 295字节
     * 用途: 极大文本数据
     */
    public static final String LONGTEXT = "LONGTEXT";

}
