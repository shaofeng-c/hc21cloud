package com.hc21cloud.umps.service;

import com.hc21cloud.common.base.constant.ServiceNameConstants;
import com.hc21cloud.common.core.support.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 用户RPC接口
 *
 * @author shaofeng
 */
@FeignClient(value = ServiceNameConstants.UMPS_SERVICE)
public interface UmpsUserRpcService {

    /**
     * 通过username获取用户信息
     *
     * @param username 用户名
     * @return Wrapper
     */
    @GetMapping(value = "/api/umps/user/info/{username}")
    Wrapper<Integer> userInfo(@PathVariable("username") String username);
}
