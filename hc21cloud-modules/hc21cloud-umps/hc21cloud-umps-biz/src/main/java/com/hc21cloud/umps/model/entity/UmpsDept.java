package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 组织部门表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsDept对象", description = "组织部门表")
public class UmpsDept extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "父级id")
    private Long parentId;
    @ApiModelProperty(value = "部门名称")
    private String name;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "负责人")
    private String leader;
    @ApiModelProperty(value = "负责人电话")
    private String phone;
    @ApiModelProperty(value = "电子邮箱")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UmpsDept{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name=" + name +
                ", sort=" + sort +
                ", leader=" + leader +
                ", phone=" + phone +
                ", email=" + email +
                "}";
    }
}