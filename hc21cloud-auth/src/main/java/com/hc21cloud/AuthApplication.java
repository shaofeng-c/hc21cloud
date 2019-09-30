package com.hc21cloud;

import com.hc21cloud.common.core.util.RedisUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author shaofeng
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }
}
