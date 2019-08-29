package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsDictType对象", description = "字典类型表")
public class UmpsDictType extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "字典类型编码")
    private String code;
    @ApiModelProperty(value = "字典类型名字")
    private String name;
    @ApiModelProperty(value = "状态（0正常 1停用）")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UmpsDictType{" +
                "id=" + id +
                ", code=" + code +
                ", name=" + name +
                ", status=" + status +
                "}";
    }
}