package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色用户表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsRoleMember对象", description = "角色用户表")
public class UmpsRoleMember extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long roleId;
    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UmpsRoleMember{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                "}";
    }
}