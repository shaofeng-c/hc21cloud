package com.hc21cloud.common.core.util;

import com.hc21cloud.common.core.config.DynamicRoutingDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Map;

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

    public static void loadDataSourceBean(BeanDefinitionRegistry beanDefinitionRegistry, DataSource defaultDatasource, Map<String, DataSource> customDataSources) {
        // bean定义类
        GenericBeanDefinition define = new GenericBeanDefinition();
        // 设置bean的类型，此处DynamicRoutingDataSource是继承AbstractRoutingDataSource的实现类
        define.setBeanClass(DynamicRoutingDataSource.class);
        // 需要注入的参数
        MutablePropertyValues mpv = define.getPropertyValues();
        // 添加默认数据源，避免key不存在的情况没有数据源可用
        mpv.add("defaultTargetDataSource", defaultDatasource);
        // 添加其他数据源
        mpv.add("targetDataSources", customDataSources);
        // 将该bean注册为datasource，不使用springboot自动生成的datasource
        beanDefinitionRegistry.registerBeanDefinition("datasource", define);
    }
}
