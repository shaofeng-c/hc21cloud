package com.h21cloud.common.core.support.page;

import com.h21cloud.common.core.util.text.StringHelper;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 分页数据
 *
 * @author shaofeng
 */
public class Page implements Serializable {
    private static final long serialVersionUID = -5008069882648261582L;
    /**
     * 当前记录起始索引
     */
    private Integer pageNum;

    /**
     * 每页显示记录数
     */
    private Integer pageSize;

    /**
     * 排序列
     */
    private String orderByColumn;
    /**
     * 排序的方式 "desc" 或者 "asc".
     */
    private String sortord;

    public String getOrderBy() {
        if (StringUtils.isEmpty(orderByColumn)) {
            return "";
        }
        return StringHelper.toUnderScoreCase(orderByColumn) + " " + sortord;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public String getSortord() {
        return sortord;
    }

    public void setSortord(String sortord) {
        this.sortord = sortord;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderByColumn='" + orderByColumn + '\'' +
                ", sortord='" + sortord + '\'' +
                '}';
    }
}
