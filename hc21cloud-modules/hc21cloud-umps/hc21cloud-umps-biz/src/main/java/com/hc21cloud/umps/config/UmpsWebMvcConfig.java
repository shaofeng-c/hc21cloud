package com.hc21cloud.umps.config;

import com.hc21cloud.common.core.config.ObjectMapper;
import com.hc21cloud.common.core.config.SwaggerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author shaofeng
 */
@Configuration
@EnableWebMvc
@Import(SwaggerConfiguration.class)
public class UmpsWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper.buildMvcMessageConverter(converters);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/");
    }
}
