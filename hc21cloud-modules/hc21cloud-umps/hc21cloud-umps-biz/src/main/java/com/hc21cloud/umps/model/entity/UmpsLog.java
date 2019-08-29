package com.hc21cloud.umps.model.entity;

import com.hc21cloud.common.core.support.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>
 * upms模块日志记录表
 * </p>
 *
 * @author shaofeng
 * @since 2019-08-29
 */
@ApiModel(value = "UmpsLog对象", description = "upms模块日志记录表")
public class UmpsLog extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "日志类型 0=登录日志 1=操作日志 2=错误日志")
    private Integer logType;
    @ApiModelProperty(value = "日志类型名称")
    private String logName;
    @ApiModelProperty(value = "操作系统")
    private String os;
    @ApiModelProperty(value = "浏览器类型")
    private String browser;
    @ApiModelProperty(value = "IP地址")
    private String ip;
    @ApiModelProperty(value = "登录位置")
    private String location;
    @ApiModelProperty(value = "物理地址")
    private String mac;
    @ApiModelProperty(value = "错误描述")
    private String errMsg;
    @ApiModelProperty(value = "请求参数")
    private String reqData;
    @ApiModelProperty(value = "请求地址")
    private String reqUrl;
    @ApiModelProperty(value = "响应结果")
    private String respData;
    @ApiModelProperty(value = "类名")
    private String className;
    @ApiModelProperty(value = "方法名")
    private String methodName;
    @ApiModelProperty(value = "开始时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @ApiModelProperty(value = "耗时,秒")
    private Integer executeTime;
    @ApiModelProperty(value = "创建人名称")
    private String createByName;
    @ApiModelProperty(value = "更新人名称")
    private String updateByName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getReqData() {
        return reqData;
    }

    public void setReqData(String reqData) {
        this.reqData = reqData;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getRespData() {
        return respData;
    }

    public void setRespData(String respData) {
        this.respData = respData;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Integer executeTime) {
        this.executeTime = executeTime;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    @Override
    public String toString() {
        return "UmpsLog{" +
                "id=" + id +
                ", logType=" + logType +
                ", logName=" + logName +
                ", os=" + os +
                ", browser=" + browser +
                ", ip=" + ip +
                ", location=" + location +
                ", mac=" + mac +
                ", errMsg=" + errMsg +
                ", reqData=" + reqData +
                ", reqUrl=" + reqUrl +
                ", respData=" + respData +
                ", className=" + className +
                ", methodName=" + methodName +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", executeTime=" + executeTime +
                ", createByName=" + createByName +
                ", updateByName=" + updateByName +
                "}";
    }
}