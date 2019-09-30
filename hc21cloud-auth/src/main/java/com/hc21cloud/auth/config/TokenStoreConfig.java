package com.hc21cloud.auth.config;

import com.hc21cloud.auth.exchange.TokenJwtEnhancer;
import com.hc21cloud.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * The class Token store config.
 *
 * @author shaofeng
 */
@Configuration
public class TokenStoreConfig {

    /**
     * 使用jwt时的配置，默认生效
     *
     * @author paascloud.net @gmail.com
     */
    @Configuration
    @ConditionalOnProperty(prefix = "hc21cloud.security.oauth2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
    public static class JwtConfig {

        @Autowired
        private SecurityProperties securityProperties;

        /**
         * Jwt token store token store.
         *
         * @return the token store
         */
        @Bean
        public TokenStore jwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        /**
         * Jwt access token converter jwt access token converter.
         *
         * @return the jwt access token converter
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            converter.setSigningKey(securityProperties.getOauth2().getJwtSignKey());
            return converter;
        }

        /**
         * Jwt token enhancer token enhancer.
         *
         * @return the token enhancer
         */
        @Bean
        @ConditionalOnBean(TokenEnhancer.class)
        public TokenEnhancer jwtTokenEnhancer() {
            return new TokenJwtEnhancer();
        }

    }
}
