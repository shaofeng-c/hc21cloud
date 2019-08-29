package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 后台管理用户表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsUser对象", description = "后台管理用户表")
public class UmpsUser extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "登录账号")
    private String username;
    @ApiModelProperty(value = "登录密码")
    private String password;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "状态 0=正常 1=禁用")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UmpsUser{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", nickname=" + nickname +
                ", avatar=" + avatar +
                ", email=" + email +
                ", status=" + status +
                "}";
    }
}