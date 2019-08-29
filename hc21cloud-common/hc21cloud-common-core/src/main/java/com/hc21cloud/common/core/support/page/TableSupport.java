package com.hc21cloud.common.core.support.page;


import com.hc21cloud.common.core.util.ServletUtils;

/**
 * 表格数据处理
 *
 * @author shaofeng
 */
public class TableSupport {

    /**
     * 当前记录起始索引
     */
    private final static String PAGE_NUM = "page";

    /**
     * 每页显示记录数
     */
    private final static String PAGE_SIZE = "limit";

    /**
     * 排序列
     */
    private final static String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    private final static String SORTORD = "sortord";

    /**
     * 封装分页对象
     */
    private static Page getPage() {
        Page page = new Page();
        page.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        page.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));
        page.setOrderByColumn(ServletUtils.getParameter(ORDER_BY_COLUMN));
        page.setSortord(ServletUtils.getParameter(SORTORD));
        return page;
    }

    public static Page buildPageRequest() {
        return getPage();
    }
}
