/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：SwaggerConfiguration.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.hc21cloud.common.core.config;

import com.google.common.collect.Lists;
import com.hc21cloud.comon.config.properties.Hc21cloudProperties;
import com.hc21cloud.comon.config.properties.SwaggerProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class Swagger configuration.
 *
 * @author shaofeng
 */
@EnableSwagger2
public class SwaggerConfiguration {

    @Resource
    private Hc21cloudProperties hc21cloudProperties;

    /**
     * Reservation api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket createRestApi() {
        // 自定义异常响应头信息
        ArrayList<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>() {
            private static final long serialVersionUID = -4024167212763681394L;

            {
                add(new ResponseMessageBuilder().code(200).message("成功").build());
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                //配置鉴权信息 全局有效，无需每个接口单独输入。
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages)
                .enable(true);
    }

    private ApiInfo apiInfo() {
        SwaggerProperties swagger = hc21cloudProperties.getSwagger();
        return new ApiInfoBuilder()
                .title(swagger.getTitle())
                .description(swagger.getDescription())
                .version(swagger.getVersion())
                .contact(new Contact(swagger.getContact().getName(),swagger.getContact().getUrl(), swagger.getContact().getEmail()))
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return Lists.newArrayList(Collections.singleton(new ApiKey("Authorization", "Authorization", "header")));
    }

    private List<SecurityContext> securityContexts() {
        return Lists.newArrayList(
                Collections.singleton(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build())
        );
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
    }

}