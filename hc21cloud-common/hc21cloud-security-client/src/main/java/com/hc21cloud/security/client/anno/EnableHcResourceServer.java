package com.hc21cloud.security.client.anno;

import com.hc21cloud.security.client.component.SecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import java.lang.annotation.*;

/**
 * @author shaofeng
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({SecurityBeanDefinitionRegistrar.class})
public @interface EnableHcResourceServer {
}

