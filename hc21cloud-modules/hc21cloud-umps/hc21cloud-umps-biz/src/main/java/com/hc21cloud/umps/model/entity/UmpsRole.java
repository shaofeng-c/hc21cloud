package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsRole对象", description = "角色表")
public class UmpsRole extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "角色名")
    private String name;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "角色状态 0=正常 1=禁用")
    private Integer status;
    @ApiModelProperty(value = "数据权限 0=本人 1=全部 2=本部门 3=本部门及下级部门")
    private Integer dataScope;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getDataScope() {
        return dataScope;
    }

    public void setDataScope(Integer dataScope) {
        this.dataScope = dataScope;
    }

    @Override
    public String toString() {
        return "UmpsRole{" +
                "id=" + id +
                ", name=" + name +
                ", sort=" + sort +
                ", status=" + status +
                ", dataScope=" + dataScope +
                "}";
    }
}