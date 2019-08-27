package com.h21cloud.common.core.support.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据
 *
 * @author shaofeng
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -121880607474866343L;
    /**
     * 结果集
     */
    private List<T> records;

    /**
     * 每页显示记录数
     */
    private Long total;

    public PageResult() {
    }

    public PageResult(List<T> records, Long total) {
        this.records = records;
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }


}
