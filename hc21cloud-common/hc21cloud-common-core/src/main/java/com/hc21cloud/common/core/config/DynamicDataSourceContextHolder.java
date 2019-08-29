package com.hc21cloud.common.core.config;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 数据源上下文
 *
 * @author shaofeng
 */
public class DynamicDataSourceContextHolder {

    private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    /**
     * 存储已经注册的数据源的key
     */
    public static List<String> dataSourceIds = Lists.newArrayList();

    /**
     * 线程级别的私有变量
     */
    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    public static String getDataSourceRouterKey() {
        return HOLDER.get();
    }

    public static void setDataSourceRouterKey(String dataSourceRouterKey) {
        log.info("切换至{}数据源", dataSourceRouterKey);
        HOLDER.set(dataSourceRouterKey);
    }

    /**
     * 设置数据源之前一定要先移除
     */
    public static void removeDataSourceRouterKey() {
        HOLDER.remove();
    }

    /**
     * 判断指定dataSource当前是否存在
     *
     * @param dataSourceId dataSourceId
     * @return boolean
     */
    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }
}
