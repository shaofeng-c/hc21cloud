package com.hc21cloud.generator.pojo.vo;


import java.io.Serializable;
import java.util.Date;

/**
 * @author shafoeng
 */
public class TableVo implements Serializable {
    private static final long serialVersionUID = -193766195565679876L;
    /**
     * 表名称
     */
    private String tableName;
    /**
     * 表描述
     */
    private String tableComment;
    private Date crtTime;
    private Date updTime;

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

    @Override
    public String toString() {
        return "TableVo{" +
                "tableName='" + tableName + '\'' +
                ", tableComment='" + tableComment + '\'' +
                ", crtTime=" + crtTime +
                ", updTime=" + updTime +
                '}';
    }
}
