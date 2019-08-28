package com.hc21cloud;

import com.hc21cloud.generator.config.GenDynamicDataSourceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 代码生成模块启动类
 *
 * @author shaofeng
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import(GenDynamicDataSourceRegister.class)
public class GenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenApplication.class, args);
    }


    @RestController
    static class TestController {
        @Autowired
        Environment env;

        @GetMapping("/test")
        public String test() {
            String activeProfiles = env.getProperty("gen.author");
            System.out.println(activeProfiles);
            return activeProfiles;
        }
    }
}
