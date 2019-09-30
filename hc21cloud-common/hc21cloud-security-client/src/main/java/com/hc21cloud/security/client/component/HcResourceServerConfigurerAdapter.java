package com.hc21cloud.security.client.component;

import com.hc21cloud.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器配置
 *
 * @author shaofeng
 */
public class HcResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 默认的配置，对外暴露
     *
     * @param httpSecurity httpSecurity
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
        httpSecurity.headers().frameOptions().disable();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                .ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        securityProperties.getIgnore().getUrls()
                .forEach(url -> registry.antMatchers(url).permitAll());
        registry.anyRequest().authenticated()
                .and().csrf().disable();
    }

}
