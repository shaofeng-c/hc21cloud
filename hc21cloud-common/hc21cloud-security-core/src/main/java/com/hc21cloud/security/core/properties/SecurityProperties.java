package com.hc21cloud.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * The class Security properties.
 *
 * @author paascloud.net@gmail.com
 */
@Component
@ConfigurationProperties(prefix = "hc21cloud.security")
public class SecurityProperties {
    /**
     * OAuth2认证服务器配置
     */
    private OAuth2Properties oauth2 = new OAuth2Properties();

    private FilterIgnoreProperties ignore = new FilterIgnoreProperties();

    public OAuth2Properties getOauth2() {
        return oauth2;
    }

    public void setOauth2(OAuth2Properties oauth2) {
        this.oauth2 = oauth2;
    }

	public FilterIgnoreProperties getIgnore() {
		return ignore;
	}

	public void setIgnore(FilterIgnoreProperties ignore) {
		this.ignore = ignore;
	}
}

