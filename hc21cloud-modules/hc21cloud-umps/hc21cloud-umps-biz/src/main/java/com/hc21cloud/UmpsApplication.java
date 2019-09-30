package com.hc21cloud;

import com.hc21cloud.security.client.anno.EnableHcResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 代码生成模块启动类
 *
 * @author shaofeng
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHcResourceServer
@EnableFeignClients
public class UmpsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmpsApplication.class, args);
    }
}
