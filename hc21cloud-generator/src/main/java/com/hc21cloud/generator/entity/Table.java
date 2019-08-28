package com.hc21cloud.generator.entity;


import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 数据库表
 *
 * @author shaofeng
 */
public class Table implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;

    /**
     * 表的主键列信息
     */
    private Column primaryKey;

    /**
     * 表的列名(不包含主键)
     */
    private List<Column> columns;

    /**
     * 类名(第一个字母大写)
     */
    private String className;

    /**
     * 类名(第一个字母小写)
     */
    private String lowClassName;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date crtTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updTime;


    public Column getColumnsLast() {
        Column columnInfo = null;
        if (columns != null && columns.size() > 0) {
            columnInfo = columns.get(0);
        }
        return columnInfo;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public Column getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Column primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLowClassName() {
        return lowClassName;
    }

    public void setLowClassName(String lowClassName) {
        this.lowClassName = lowClassName;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
}
