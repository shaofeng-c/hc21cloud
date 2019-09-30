package com.hc21cloud.security.client.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shaofeng
 */
public class SecurityBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    private final static Logger log = LoggerFactory.getLogger(SecurityBeanDefinitionRegistrar.class);
    private final static String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";

    /**
     * 根据注解值动态注入资源服务器的相关属性
     *
     * @param metadata 注解信息
     * @param registry 注册器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        if (registry.isBeanNameInUse(RESOURCE_SERVER_CONFIGURER)) {
            log.warn("本地存在资源服务器配置，覆盖默认配置:" + RESOURCE_SERVER_CONFIGURER);
            return;
        }
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(HcResourceServerConfigurerAdapter.class);
        registry.registerBeanDefinition(RESOURCE_SERVER_CONFIGURER, beanDefinition);
    }
}
