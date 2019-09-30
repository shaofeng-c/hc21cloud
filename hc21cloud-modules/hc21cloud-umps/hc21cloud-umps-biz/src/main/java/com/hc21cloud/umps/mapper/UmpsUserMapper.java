package com.hc21cloud.umps.mapper;

import com.hc21cloud.umps.model.entity.UmpsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 后台管理用户 DAO
 *
 * @author shaofeng
 * @date Fri Sep 06 17:06:43 CST 2019
 * @since Fri Sep 06 17:06:43 CST 2019
 */
@Mapper
public interface UmpsUserMapper {
    /**
     * selectById
     *
     * @param id id
     * @return UmpsUser
     */
    UmpsUser selectById(Long id);

    /**
     * selectList
     *
     * @param umpsUser UmpsUser
     * @return List
     */
    List<UmpsUser> selectList(UmpsUser umpsUser);

    /**
     * insert
     *
     * @param umpsUser UmpsUser
     * @return int
     */
    int insert(UmpsUser umpsUser);

    /**
     * update
     *
     * @param umpsUser UmpsUser
     * @return int
     */
    int update(UmpsUser umpsUser);

    /**
     * 根据id删除信息
     *
     * @param id id
     * @return int
     */
    int deleteById(Long id);

}