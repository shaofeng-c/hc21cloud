/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：GlobalConstant.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */
package com.hc21cloud.common.base.constant;

/**
 * The class Global constant.
 *
 * @author shaofeng
 * @version 1.0.0
 * @date 2019-08-21
 */
public class GlobalConstants {

    public static final String JSON_CONTENT_TYPE = "application/json";
    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    public static final String JSON_SUFFIX = ".json";
    public static final String XML_SUFFIX = ".xml";

    public static final String UNKNOWN = "unknown";

    public static final String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String X_REAL_IP = "X-Real-IP";
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";

    public static final String LOCALHOST_IP = "127.0.0.1";
    public static final String LOCALHOST_IP_16 = "0:0:0:0:0:0:0:1";
    public static final int MAX_IP_LENGTH = 15;

    public interface Number {
        int THOUSAND_INT = 1000;
        int HUNDRED_INT = 100;
        int ONE_INT = 1;
        int TWO_INT = 2;
        int THREE_INT = 3;
        int FOUR_INT = 4;
        int FIVE_INT = 5;
        int SIX_INT = 6;
        int SEVEN_INT = 7;
        int EIGHT_INT = 8;
        int NINE_INT = 9;
        int TEN_INT = 10;
        int EIGHTEEN_INT = 18;
    }


    /**
     * 系统常量
     *
     * @author shaofeng
     */
    public static final class Sys {

        private Sys() {
        }

    }

    /**
     * The class Symbol.
     *
     * @author shaofeng
     */
    public static final class Symbol {
        private Symbol() {
        }

        /**
         * The constant COMMA.
         */
        public static final String COMMA = ",";
        /**
         * The constant SPOT.
         */
        public static final String SPOT = ".";
        /**
         * The constant UNDER_LINE.
         */
        public final static String UNDER_LINE = "_";
        /**
         * The constant PER_CENT.
         */
        public final static String PER_CENT = "%";
        /**
         * The constant AT.
         */
        public final static String AT = "@";
        /**
         * The constant PIPE.
         */
        public final static String PIPE = "||";
        /**
         * The constant SHORT_LINE.
         */
        public final static String SHORT_LINE = "-";
        /**
         * The constant SPACE.
         */
        public final static String SPACE = " ";
        /**
         * The constant SLASH.
         */
        public static final String SLASH = "/";
        /**
         * The constant MH.
         */
        public static final String MH = ":";

    }

}
