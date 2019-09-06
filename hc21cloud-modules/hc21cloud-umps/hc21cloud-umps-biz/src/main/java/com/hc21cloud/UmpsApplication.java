package com.hc21cloud;

import com.hc21cloud.umps.register.UmpsDynamicDataSourceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码生成模块启动类
 *
 * @author shaofeng
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import(UmpsDynamicDataSourceRegister.class)
public class UmpsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmpsApplication.class, args);
    }
}
