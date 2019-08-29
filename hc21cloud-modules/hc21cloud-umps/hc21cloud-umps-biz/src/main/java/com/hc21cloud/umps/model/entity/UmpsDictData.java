package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsDictData对象", description = "字典数据表")
public class UmpsDictData extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "字典编码")
    private String code;
    @ApiModelProperty(value = "标签名")
    private String label;
    @ApiModelProperty(value = "字典值")
    private String value;
    @ApiModelProperty(value = "是否默认 1=默认")
    private Integer isDefault;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        return "UmpsDictData{" +
                "id=" + id +
                ", code=" + code +
                ", label=" + label +
                ", value=" + value +
                ", isDefault=" + isDefault +
                ", sort=" + sort +
                ", status=" + status +
                "}";
    }
}