package com.hc21cloud.security.core.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

/**
 * 认证失败事件处理器
 *
 * @author shaofeng
 */
public abstract class AbstractAuthenticationSuccessEvenHandler implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        if (authentication.getAuthorities() != null) {
            handle(authentication);
        }
    }


    /**
     * 处理方法
     * <p>
     *
     * @param authentication 登录对象
     */
    public abstract void handle(Authentication authentication);
}
