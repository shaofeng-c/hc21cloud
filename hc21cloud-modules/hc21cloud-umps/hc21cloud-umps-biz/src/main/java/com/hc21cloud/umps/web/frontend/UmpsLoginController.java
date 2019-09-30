/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacUserLoginController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.hc21cloud.umps.web.frontend;

import com.hc21cloud.common.core.support.base.BaseController;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录相关.
 *
 * @author shaofeng
 */
@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - UacLoginController", tags = {"WEB - UacLoginController - 后台管理用户登录WEB接口"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UmpsLoginController extends BaseController {

}