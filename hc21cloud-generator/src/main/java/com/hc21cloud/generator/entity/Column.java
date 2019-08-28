package com.hc21cloud.generator.entity;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 数据库表列信息
 *
 * @author shaofeng
 */
public class Column implements Serializable {

    private static final long serialVersionUID = 8759257972721702410L;
    /**
     * 字段名称
     */
    private String columnName;

    /**
     * 字段类型
     */
    private String dataType;

    /**
     * 列描述
     */
    private String columnComment;

    /**
     * 列配置
     */
    private ColumnConfig configInfo;

    /**
     * Java属性类型
     */
    private String attrType;

    /**
     * Java属性名称(第一个字母大写)，如：user_name => UserName
     */
    private String attrName;

    /**
     * Java属性名称(第一个字母小写)，如：user_name => userName
     */
    private String lowAttrName;

    public void setColumnComment(String columnComment) {
        // 根据列描述解析列的配置信息
        if (StringUtils.isNotEmpty(columnComment) && columnComment.startsWith("{")) {
            this.configInfo = JSONObject.parseObject(columnComment, ColumnConfig.class);
            this.columnComment = configInfo.getTitle();
        } else {
            this.columnComment = columnComment;
        }
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public ColumnConfig getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(ColumnConfig configInfo) {
        this.configInfo = configInfo;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getLowAttrName() {
        return lowAttrName;
    }

    public void setLowAttrName(String lowAttrName) {
        this.lowAttrName = lowAttrName;
    }

    @Override
    public String toString() {
        return "Column{" +
                "columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", configInfo=" + configInfo +
                ", attrType='" + attrType + '\'' +
                ", attrName='" + attrName + '\'' +
                ", lowAttrName='" + lowAttrName + '\'' +
                '}';
    }
}
