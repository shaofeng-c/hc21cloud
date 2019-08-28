package com.hc21cloud.generator.constant;

/**
 * GEN常量表
 *
 * @author shaofeng
 */
public class GenConstants {

    /**
     * 单表（增删改查）
     */
    public static final String TPL_CRUD = "crud";

    /**
     * 树表（增删改查）
     */
    public static final String TPL_TREE = "tree";

    /**
     * 树编码字段
     */
    public static final String TREE_CODE = "treeCode";

    /**
     * 树父编码字段
     */
    public static final String TREE_PARENT_CODE = "treeParentCode";

    /**
     * 树名称字段
     */
    public static final String TREE_NAME = "treeName";

    /**
     * 数据库字符串类型
     */
    public static final String[] COLUMN_TYPE_STR = {"char", "varchar", "varchar", "varchar2", "tinytext", "text",
            "mediumtext", "longtext"};

    /**
     * 数据库时间类型
     */
    public static final String[] COLUMN_TYPE_TIME = {"datetime", "time", "date", "timestamp"};

    /**
     * 数据库数字类型
     */
    public static final String[] COLUMN_TYPE_NUMBER = {"tinyint", "smallint", "mediumint", "int", "number", "integer",
            "bigint", "float", "float", "double", "decimal"};

    /**
     * 字符串类型
     */
    public static final String TYPE_STRING = "String";

    /**
     * 整型
     */
    public static final String TYPE_INTEGER = "Integer";

    /**
     * 长整型
     */
    public static final String TYPE_LONG = "Long";

    /**
     * 浮点型
     */
    public static final String TYPE_DOUBLE = "Double";

    /**
     * 高精度计算类型
     */
    public static final String TYPE_BIG_DECIMAL = "BigDecimal";

    /**
     * 时间类型
     */
    public static final String TYPE_DATE = "Date";

    /**
     * 模糊查询
     */
    public static final String QUERY_LIKE = "LIKE";

    /**
     * 需要
     */
    public static final String REQUIRE = "1";
}
