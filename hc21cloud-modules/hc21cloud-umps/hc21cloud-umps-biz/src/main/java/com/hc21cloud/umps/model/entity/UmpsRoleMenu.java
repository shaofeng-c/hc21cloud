package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色权限资源表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsRoleMenu对象", description = "角色权限资源表")
public class UmpsRoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long roleId;
    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "UmpsRoleMenu{" +
                "roleId=" + roleId +
                ", menuId=" + menuId +
                "}";
    }
}