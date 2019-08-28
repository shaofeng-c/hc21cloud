package com.h21cloud.common.core.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源路由配置
 *
 * @author shaofeng
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private static Logger log = LoggerFactory.getLogger(DynamicRoutingDataSource.class);
    /**
     * 该方法负责判断当前线程使用哪一种数据源
     *
     * @return Object
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceContextHolder.getDataSourceRouterKey();
        log.info("当前数据源是：{}", dataSourceName);
        return dataSourceName;
    }
}