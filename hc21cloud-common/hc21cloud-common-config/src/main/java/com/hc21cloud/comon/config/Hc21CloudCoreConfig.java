package com.hc21cloud.comon.config;

import com.hc21cloud.comon.config.properties.Hc21cloudProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The class core config.
 *
 * @author shaofengo
 */
@Configuration
@EnableConfigurationProperties(Hc21cloudProperties.class)
public class Hc21CloudCoreConfig {
}
