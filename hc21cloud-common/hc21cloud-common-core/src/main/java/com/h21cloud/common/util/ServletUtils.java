package com.h21cloud.common.util;

import com.h21cloud.common.constant.GlobalConstant;
import com.h21cloud.common.util.text.Convert;
import com.h21cloud.common.util.text.StringHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 客户端工具类
 *
 * @author shaofeng
 */
public class ServletUtils {

    private static final Logger log = LoggerFactory.getLogger(ServletUtils.class);

    /**
     * 获取String参数
     *
     * @param key 键
     * @return String
     */
    public static String getParameter(String key) {
        return getRequest().getParameter(key);
    }

    /**
     * 获取String参数
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return String
     */
    public static String getParameter(String key, String defaultValue) {
        return Convert.toStr(getRequest().getParameter(key), defaultValue);
    }

    /**
     * 获取Integer参数
     *
     * @param key 键
     * @return Integer
     */
    public static Integer getParameterToInt(String key) {
        return Convert.toInt(getRequest().getParameter(key));
    }

    /**
     * 获取Integer参数
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return Integer
     */
    public static Integer getParameterToInt(String key, Integer defaultValue) {
        return Convert.toInt(getRequest().getParameter(key), defaultValue);
    }

    /**
     * 获取request
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取Response
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取session
     *
     * @return HttpSession
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * ServletRequestAttributes
     *
     * @return ServletRequestAttributes
     */
    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 是否是Ajax异步请求
     *
     * @param request the request
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {

        String accept = request.getHeader("accept");
        if (accept != null && GlobalConstant.JSON_CONTENT_TYPE.contains(accept)) {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (GlobalConstant.XML_HTTP_REQUEST.equals(xRequestedWith)) {
            return true;
        }

        String uri = request.getRequestURI();

        if (StringHelper.inStringIgnoreCase(uri, GlobalConstant.JSON_SUFFIX, GlobalConstant.XML_SUFFIX)) {
            return true;
        }

        String ajax = request.getParameter("__ajax");
        return StringHelper.inStringIgnoreCase(ajax, GlobalConstant.JSON_SUFFIX, GlobalConstant.XML_SUFFIX);
    }

    /**
     * 获得用户远程地址
     *
     * @param request the request
     * @return the string
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader(GlobalConstant.X_REAL_IP);
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.X_FORWARDED_FOR);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.WL_PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.HTTP_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.HTTP_X_FORWARDED_FOR);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (GlobalConstant.LOCALHOST_IP.equals(ipAddress) || GlobalConstant.LOCALHOST_IP_16.equals(ipAddress)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    log.error("获取IP地址, 出现异常={}", e.getMessage(), e);
                }
                assert inet != null;
                ipAddress = inet.getHostAddress();
            }
            log.info("获取IP地址 ipAddress={}", ipAddress);
        }
        // 对于通过多个代理的情况, 第一个IP为客户端真实IP,多个IP按照','分割 //"***.***.***.***".length() = 15
        if (ipAddress != null && ipAddress.length() > GlobalConstant.MAX_IP_LENGTH) {
            if (ipAddress.indexOf(GlobalConstant.Symbol.COMMA) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(GlobalConstant.Symbol.COMMA));
            }
        }
        return ipAddress;
    }
}
