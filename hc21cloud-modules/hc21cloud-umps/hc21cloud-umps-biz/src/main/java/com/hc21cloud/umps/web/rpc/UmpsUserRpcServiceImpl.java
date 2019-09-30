package com.hc21cloud.umps.web.rpc;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hc21cloud.common.core.support.base.BaseController;
import com.hc21cloud.common.core.support.wrapper.WrapHandler;
import com.hc21cloud.common.core.support.wrapper.Wrapper;
import com.hc21cloud.umps.model.entity.UmpsUser;
import com.hc21cloud.umps.service.UmpsUserRpcService;
import com.hc21cloud.umps.service.UmpsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 后台管理用户表 前端控制器
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@RestController
@Api(value = "RPC - UmpsUserRpcService", tags = {"RPC - UmpsUserRpcService - 后台管理用户RPC接口"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UmpsUserRpcServiceImpl extends BaseController implements UmpsUserRpcService {

    @Resource
    private UmpsUserService umpsUserService;

    @Override
    @ApiOperation(value = "更新token离线状态")
    public Wrapper<Integer> userInfo(String username) {
        umpsUserService.selectById(1L);
        return WrapHandler.ok(1);
    }
}

