package com.hc21cloud.generator.util;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.h21cloud.common.core.util.text.StringHelper;
import com.hc21cloud.generator.entity.Column;
import com.hc21cloud.generator.entity.Table;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器 工具类
 *
 * @author shaofeng
 */
public class GenUtils {
    /**
     * mybatis空间路径
     */
    private static final String MYBATIS_PATH = "main/resources/mapper";

    /**
     * html空间路径
     */
    private static final String TEMPLATES_PATH = "main/resources/templates";

    /**
     * 类型转换
     */
    public static Map<String, String> javaTypeMap = Maps.newHashMap();

    /**
     * 设置列信息
     */
    public static List<Column> transColumns(List<Column> columns) {
        // 列信息
        List<Column> columnList = new ArrayList<>();
        for (Column column : columns) {
            // 列名转换成Java属性名
            String attrName = StringHelper.convertToCamelCase(column.getColumnName());
            column.setAttrName(attrName);
            column.setLowAttrName(StringUtils.uncapitalize(attrName));

            // 列的数据类型，转换成Java类型
            String attrType = javaTypeMap.get(column.getDataType());
            column.setAttrType(attrType);

            columnList.add(column);
        }
        return columnList;
    }

    /**
     * 获取模板信息
     *
     * @return 模板列表
     */
    public static VelocityContext getVelocityContext(Table table, String packageName, String author) {
        // java对象数据传递到模板文件vm
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("tableName", table.getTableName());
        velocityContext.put("tableComment", replaceKeyword(table.getTableComment()));
        velocityContext.put("primaryKey", table.getPrimaryKey());
        velocityContext.put("className", table.getClassName());
        velocityContext.put("classname", table.getLowClassName());
        velocityContext.put("moduleName", getModuleName(packageName));
        velocityContext.put("columns", table.getColumns());
        velocityContext.put("basePackage", getBasePackage(packageName));
        velocityContext.put("package", packageName);
        velocityContext.put("author", author);
        velocityContext.put("datetime", new Date());
        return velocityContext;
    }

    /**
     * 获取模板信息
     *
     * @return 模板列表
     */
    public static List<String> getTemplates() {
        List<String> templates = Lists.newArrayList();
        templates.add("vm/java/Entity.java.vm");
        templates.add("vm/java/Mapper.java.vm");
        templates.add("vm/java/Service.java.vm");
        templates.add("vm/java/ServiceImpl.java.vm");
        templates.add("vm/xml/Mapper.xml.vm");
        return templates;
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, boolean autoRemovePre) {
        if (autoRemovePre) {
            tableName = tableName.substring(tableName.indexOf("_") + 1);
        }
        return StringHelper.convertToCamelCase(tableName);
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, Table table, String moduleName, String packageName) {
        // 大写类名
        String className = table.getClassName();
        String javaPath = getProjectPath(packageName);
        String mybatisPath = MYBATIS_PATH + "/" + className;
        if (template.contains("Entity.java.vm")) {
            return javaPath + "entity" + "/" + className + ".java";
        }
        if (template.contains("Mapper.java.vm")) {
            return javaPath + "mapper" + "/" + className + "Mapper.java";
        }
        if (template.contains("Service.java.vm")) {
            return javaPath + "service" + "/" + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return javaPath + "service" + "/impl/" + className + "ServiceImpl.java";
        }
        if (template.contains("Mapper.xml.vm")) {
            return mybatisPath + "Mapper.xml";
        }
        return null;
    }

    /**
     * 获取模块名
     *
     * @param packageName 包名
     * @return 模块名
     */
    public static String getModuleName(String packageName) {
        int lastIndex = packageName.lastIndexOf(".");
        int nameLength = packageName.length();
        return StringUtils.substring(packageName, lastIndex + 1, nameLength);
    }

    public static String getBasePackage(String packageName) {
        int lastIndex = packageName.lastIndexOf(".");
        return StringUtils.substring(packageName, 0, lastIndex);
    }

    public static String getProjectPath(String packageName) {
        return "main/java/" +
                packageName.replace(".", "/") +
                "/";
    }

    public static String replaceKeyword(String keyword) {
        return keyword.replaceAll("(?:表|信息)", "");
    }

    static {
        javaTypeMap.put("tinyint", "Integer");
        javaTypeMap.put("smallint", "Integer");
        javaTypeMap.put("mediumint", "Integer");
        javaTypeMap.put("int", "Integer");
        javaTypeMap.put("integer", "integer");
        javaTypeMap.put("bigint", "Long");
        javaTypeMap.put("float", "Float");
        javaTypeMap.put("double", "Double");
        javaTypeMap.put("decimal", "BigDecimal");
        javaTypeMap.put("bit", "Boolean");
        javaTypeMap.put("char", "String");
        javaTypeMap.put("varchar", "String");
        javaTypeMap.put("tinytext", "String");
        javaTypeMap.put("text", "String");
        javaTypeMap.put("mediumtext", "String");
        javaTypeMap.put("longtext", "String");
        javaTypeMap.put("time", "Date");
        javaTypeMap.put("date", "Date");
        javaTypeMap.put("datetime", "Date");
        javaTypeMap.put("timestamp", "Date");
    }
}
