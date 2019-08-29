package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 权限资源表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsMenu对象", description = "权限资源表")
public class UmpsMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "权限标识符")
    private String code;
    @ApiModelProperty(value = "父级id")
    private Long parentId;
    @ApiModelProperty(value = "菜单名")
    private String name;
    @ApiModelProperty(value = "菜单类型 0=目录 1=菜单 2=按钮")
    private Integer type;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "状态 0=正常 1=禁用")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UmpsMenu{" +
                "id=" + id +
                ", code=" + code +
                ", parentId=" + parentId +
                ", name=" + name +
                ", type=" + type +
                ", sort=" + sort +
                ", status=" + status +
                "}";
    }
}