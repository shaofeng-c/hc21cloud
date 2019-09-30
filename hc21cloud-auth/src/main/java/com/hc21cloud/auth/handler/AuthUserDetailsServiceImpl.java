package com.hc21cloud.auth.handler;

import com.alibaba.fastjson.JSONObject;
import com.hc21cloud.common.core.util.RedisUtils;
import com.hc21cloud.security.core.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 默认的 UserDetailsService 实现
 * 不做任何处理，只在控制台打印一句日志，然后抛出异常，提醒业务系统自己配置 UserDetailsService。
 *
 * @author shaofeng
 */
@Service("userDetailsService")
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(AuthUserDetailsServiceImpl.class);

    @Autowired
    private RedisUtils redisUtils;

    /**
     * Load user by username user details.
     *
     * @param username the username
     * @return the user details
     * @throws UsernameNotFoundException the username not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = JSONObject.parseObject(JSONObject.toJSONString(redisUtils.get(username)), AuthUser.class);
        if (authUser==null) {
            // TODO: 获取user
        }
        return authUser;
    }

}
