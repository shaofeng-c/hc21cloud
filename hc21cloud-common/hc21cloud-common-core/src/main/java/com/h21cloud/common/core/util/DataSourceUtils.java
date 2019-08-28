package com.h21cloud.common.core.util;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * 数据源工具类
 *
 * @author shaofeng
 */
public class DataSourceUtils {

    /**
     * 通过字符串获取数据源class对象
     *
     * @param typeStr typeStr
     * @return DataSource
     */
    public static Class<? extends DataSource> getDataSourceType(String typeStr) {
        Class<? extends DataSource> type;
        try {
            if (StringUtils.hasLength(typeStr)) {
                type = (Class<? extends DataSource>) Class.forName(typeStr);
            } else {
                type = HikariDataSource.class;
            }
            return type;
        } catch (Exception e) {
            //无法通过反射获取class对象的情况则抛出异常，该情况一般是写错了
            throw new IllegalArgumentException("can not resolve class with type: " + typeStr);
        }
    }
}
