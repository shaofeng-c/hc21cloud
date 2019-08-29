/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：PaascloudProperties.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.hc21cloud.comon.config.properties;


import com.hc21cloud.common.base.constant.GlobalConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The class Hc21cloud Properties.
 *
 * @author shaoofeng
 */
@ConfigurationProperties(prefix = GlobalConstants.ROOT_PREFIX)
public class Hc21cloudProperties {

    private SwaggerProperties swagger = new SwaggerProperties();

    public SwaggerProperties getSwagger() {
        return swagger;
    }

    public void setSwagger(SwaggerProperties swagger) {
        this.swagger = swagger;
    }
}
