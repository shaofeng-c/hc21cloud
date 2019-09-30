/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：OAuth2Properties.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.hc21cloud.security.core.properties;


/**
 * The class O auth 2 properties.
 *
 * @author shaofeng
 */
public class OAuth2Properties {

    /**
     * 使用jwt时为token签名的秘钥
     */
    private String jwtSignKey = "hc21cloud";

    public String getJwtSignKey() {
        return jwtSignKey;
    }

    public void setJwtSignKey(String jwtSignKey) {
        this.jwtSignKey = jwtSignKey;
    }
}
