package com.hc21cloud.umps.web.frontend;

import com.hc21cloud.common.core.support.base.BaseController;
import com.hc21cloud.common.core.support.wrapper.WrapHandler;
import com.hc21cloud.common.core.support.wrapper.Wrapper;
import com.hc21cloud.umps.model.entity.UmpsUser;
import com.hc21cloud.umps.service.UmpsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台管理用户表 前端控制器
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@RestController
@RequestMapping("/user")
@Api(value = "WEB - UmpsUserRest", tags = {"WEB - UmpsUserRest - 后台管理用户WEB接口"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UmpsUserController extends BaseController {

    @Resource
    private UmpsUserService umpsUserService;

    @GetMapping("/list")
    @ApiOperation(value = "查询用户列表")
    public Wrapper<List<UmpsUser>> list(@ApiParam(name = "user", value = "用户信息") UmpsUser user) {
        List<UmpsUser> users = umpsUserService.selectList(user);
        return WrapHandler.ok(users);
    }
}

