package com.hc21cloud.umps.web.frontend;

import com.hc21cloud.common.core.support.wrapper.WrapHandler;
import com.hc21cloud.common.core.support.wrapper.Wrapper;
import com.hc21cloud.umps.model.entity.UmpsUser;
import com.hc21cloud.umps.service.UmpsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hc21cloud.common.core.support.base.BaseController;

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
@Api(value = "WEB - UmpsUserRest", tags = {"WEB - UmpsUserRest"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UmpsUserController extends BaseController {

    @Resource
    private UmpsUserService umpsUserService;

    @GetMapping(value = "/get")
    @ApiOperation(value = "查看四级地址")
    public Wrapper<UmpsUser> get() {
        return WrapHandler.ok(umpsUserService.selectById(1L));
    }
}

