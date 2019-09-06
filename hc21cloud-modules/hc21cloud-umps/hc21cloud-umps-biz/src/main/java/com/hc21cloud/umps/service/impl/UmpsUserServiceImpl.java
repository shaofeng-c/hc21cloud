package com.hc21cloud.umps.service.impl;

import java.util.List;

import com.hc21cloud.common.core.support.base.BaseService;
import org.springframework.stereotype.Service;
import com.hc21cloud.umps.mapper.UmpsUserMapper;
import com.hc21cloud.umps.model.entity.UmpsUser;
import com.hc21cloud.umps.service.UmpsUserService;

/**
 * 后台管理用户 服务层实现
 *
 * @author shaofeng
 * @date Fri Sep 06 17:06:43 CST 2019
 */
@Service
public class UmpsUserServiceImpl extends BaseService<UmpsUserMapper> implements UmpsUserService {

    @Override
    public UmpsUser selectById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<UmpsUser> selectList(UmpsUser umpsUser) {
        return baseMapper.selectList(umpsUser);
    }

    @Override
    public int insert(UmpsUser umpsUser) {
        return baseMapper.insert(umpsUser);
    }

    @Override
    public int update(UmpsUser umpsUser) {
        return baseMapper.update(umpsUser);
    }

    @Override
    public int deleteById(Long id) {
        return baseMapper.deleteById(id);
    }

}