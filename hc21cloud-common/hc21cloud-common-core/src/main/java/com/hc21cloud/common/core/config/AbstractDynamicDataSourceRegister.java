package com.hc21cloud.common.core.config;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 动态数据源注册
 * 实现 ImportBeanDefinitionRegistrar 实现数据源注册
 * 实现 EnvironmentAware 用于读取application.yml配置
 *
 * @author shaofeng
 */
public class AbstractDynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    public static final Logger log = LoggerFactory.getLogger(AbstractDynamicDataSourceRegister.class);
    /**
     * 配置上下文（也可以理解为配置文件的获取工具）
     */
    public Environment env;

    /**
     * 存储我们注册的数据源
     */
    public Map<String, DataSource> customDataSources = Maps.newHashMap();

    /**
     * 参数绑定工具 springboot2.0新推出
     */
    public Binder binder;

    @Override
    public void setEnvironment(Environment environment) {
        log.info("开始注册数据源");
        this.env = environment;
        // 绑定配置器
        binder = Binder.get(env);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
    }

}
