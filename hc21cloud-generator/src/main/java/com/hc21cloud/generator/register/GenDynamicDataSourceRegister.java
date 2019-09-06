package com.hc21cloud.generator.register;

import com.hc21cloud.common.core.config.AbstractDynamicDataSourceRegister;
import com.hc21cloud.common.core.config.DynamicDataSourceContextHolder;
import com.hc21cloud.common.core.util.BinderUtils;
import com.hc21cloud.common.core.util.DataSourceUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * umps模块动态数据源注册
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
        DataSourceUtils.loadDataSourceBean(beanDefinitionRegistry, defaultDatasource, customDataSources);
        log.info("注册数据源成功，一共注册{}个数据源", customDataSources.keySet().size() + 1);
    }
}
