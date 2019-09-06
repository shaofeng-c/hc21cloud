/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：BaseService.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.hc21cloud.common.core.support.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The class Base service.
 *
 * @param <T> the type parameter
 * @author shaofeng
 */
public abstract class BaseService<T> {

    /**
     * The Logger.
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * The Mapper.
     */
    @Autowired
    public T baseMapper;

    /**
     * Gets mapper.
     *
     * @return the mapper
     */
    public T getMapper() {
        return baseMapper;
    }

}
