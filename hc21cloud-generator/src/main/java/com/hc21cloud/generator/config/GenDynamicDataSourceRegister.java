package com.hc21cloud.generator.config;

import com.h21cloud.common.core.config.AbstractDynamicDataSourceRegister;
import com.h21cloud.common.core.config.DynamicDataSourceContextHolder;
import com.h21cloud.common.core.config.DynamicRoutingDataSource;
import com.h21cloud.common.core.util.BinderUtils;
import com.h21cloud.common.core.util.DataSourceUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * gen模块动态数据源注册
 *
 * @author shaofeng
 */
public class GenDynamicDataSourceRegister extends AbstractDynamicDataSourceRegister {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 获取所有数据源配置
        Map config, defaultDataSourceProperties;
        defaultDataSourceProperties = binder.bind("spring.datasource.master", Map.class).get();
        // 获取数据源类型
        String typeStr = env.getProperty("spring.datasource.master.type");
        // 获取数据源类型
        Class<? extends DataSource> clazz = DataSourceUtils.getDataSourceType(typeStr);
        // 绑定默认数据源参数 也就是主数据源
        DataSource consumerDatasource, defaultDatasource = BinderUtils.bind(clazz, defaultDataSourceProperties);
        DynamicDataSourceContextHolder.dataSourceIds.add("master");
        log.info("注册默认数据源成功");
        // 获取其他数据源配置
        List<Map> configs = binder.bind("spring.datasource.custom", Bindable.listOf(Map.class)).get();
        // 遍历从数据源
        for (Map map : configs) {
            config = map;
            clazz = DataSourceUtils.getDataSourceType((String) config.get("type"));
            // 绑定参数
            consumerDatasource = BinderUtils.bind(clazz, config);
            // 获取数据源的key，以便通过该key可以定位到数据源
            String key = config.get("key").toString();
            customDataSources.put(key, consumerDatasource);
            // 数据源上下文，用于管理数据源与记录已经注册的数据源key
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
            log.info("注册数据源{}成功", key);
        }
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
        log.info("注册数据源成功，一共注册{}个数据源", customDataSources.keySet().size() + 1);
    }
}
