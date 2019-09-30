package com.hc21cloud.auth.handler;

import com.hc21cloud.security.core.handler.AbstractAuthenticationSuccessEvenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 认证成功处理器
 *
 * @author shaofeng
 */
@Component
public class AuthenticationSuccessEventHandler extends AbstractAuthenticationSuccessEvenHandler {

    private final static Logger log = LoggerFactory.getLogger(AuthenticationSuccessEventHandler.class);

    @Override
    public void handle(Authentication authentication) {
        log.info("用户：{} 登录成功", authentication.getPrincipal());

        //TODO: 登录成功处理逻辑
    }
}
