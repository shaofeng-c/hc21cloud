package com.h21cloud.common.core.util.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * http请求工具类
 *
 * @author shaofeng
 */
public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
    /**
     * 编码格式。发送编码格式统一用UTF-8
     */
    private static final String ENCODING = "UTF-8";

    /**
     * 设置连接超时时间，单位毫秒。
     */
    private static final int CONNECT_TIMEOUT = 6000;

    /**
     * 请求获取数据的超时时间(即响应时间)，单位毫秒。
     */
    private static final int SOCKET_TIMEOUT = 6000;

    /**
     * 发送get请求；不带请求头和请求参数
     *
     * @param url 请求地址
     * @return JSONObject
     */
    public static JSONObject doGet(String url) {
        return doGet(url, null, null);
    }

    /**
     * 发送get请求；带请求参数
     *
     * @param url   请求地址
     * @param query 请求参数集合
     * @return JSONObject
     */
    public static JSONObject doGet(String url, Map<String, String> query) {
        return doGet(url, null, query);
    }

    /**
     * 发送get请求；带请求头和请求参数
     *
     * @param url     请求地址
     * @param headers 请求头集合
     * @param query   请求参数集合
     * @return JSONObject
     */
    public static JSONObject doGet(String url, Map<String, String> headers, Map<String, String> query) {
        // 创建httpClient对象
        CloseableHttpClient httpClient = wrapClient(url);
        // 创建http对象
        HttpGet httpGet = new HttpGet(buildUrl(url, query));
        // setConnectTimeout：设置连接超时时间，单位毫秒。
        // setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
        // 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
        // setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpGet.setConfig(requestConfig);
        // 设置请求头
        packageHeader(headers, httpGet);
        // 创建httpResponse对象
        CloseableHttpResponse httpResponse = null;
        try {
            // 执行请求并获得响应结果
            return getHttpClientResult(httpResponse, httpClient, httpGet);
        } finally {
            // 释放资源
            release(httpResponse, httpClient);
        }
    }

    /**
     * 发送post请求；带JSON参数
     *
     * @param url  请求地址
     * @param json JSON
     * @return JSONObject
     */
    public static JSONObject doPost(String url, String json) {
        return doPost(url, null, null, json);
    }

    /**
     * 发送post请求；带query参数
     *
     * @param url   请求地址
     * @param query 参数集合
     * @return JSONObject
     */
    public static JSONObject doPost(String url, Map<String, String> query) {
        return doPost(url, null, query, null);
    }

    /**
     * 发送post请求；带JSON参数
     *
     * @param url  请求地址
     * @param json JSON
     * @return JSONObject
     */
    public static JSONObject doPost(String url, Map<String, String> headers, String json) {
        return doPost(url, headers, null, json);
    }

    /**
     * 发送post请求；带query参数
     *
     * @param url   请求地址
     * @param query 参数集合
     * @return JSONObject
     */
    public static JSONObject doPost(String url, Map<String, String> headers, Map<String, String> query) {
        return doPost(url, headers, query, null);
    }

    /**
     * 发送post请求
     *
     * @param url     请求地址
     * @param headers 请求头
     * @param query   url请求参数
     * @param body    json
     * @return JSONObject
     */
    public static JSONObject doPost(String url, Map<String, String> headers, Map<String, String> query, String body) {
        // 创建httpClient对象
        CloseableHttpClient httpClient = wrapClient(url);
        // 创建http对象
        HttpPost httpPost = new HttpPost(buildUrl(url, query));
        // setConnectTimeout：设置连接超时时间，单位毫秒。
        // setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
        // 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
        // setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPost.setConfig(requestConfig);
        // 设置请求头
        packageHeader(headers, httpPost);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        if (StringUtils.isNotBlank(body)) {
            // 构建消息实体
            StringEntity entity = new StringEntity(body, Charset.forName(ENCODING));
            entity.setContentEncoding(ENCODING);
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
        }
        // 创建httpResponse对象
        CloseableHttpResponse httpResponse = null;
        try {
            // 执行请求并获得响应结果
            return getHttpClientResult(httpResponse, httpClient, httpPost);
        } finally {
            // 释放资源
            release(httpResponse, httpClient);
        }
    }

    /**
     * 在调用SSL之前需要重写验证方法，取消检测SSL
     * 创建ConnectionManager，添加Connection配置信息
     *
     * @return HttpClient 支持https
     */
    private static CloseableHttpClient sslClient() {
        try {
            // 在调用SSL之前需要重写验证方法，取消检测SSL
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                }
            };
            SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            ctx.init(null, new TrustManager[]{trustManager}, null);
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
            // 创建Registry
            RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
                    .setExpectContinueEnabled(Boolean.TRUE).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                    .setProxyPreferredAuthSchemes(Collections.singletonList(AuthSchemes.BASIC)).build();
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", socketFactory).build();
            // 创建ConnectionManager，添加Connection配置信息
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            return HttpClients.custom().setConnectionManager(connectionManager)
                    .setDefaultRequestConfig(requestConfig).build();
        } catch (KeyManagementException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 构建请求的
     *
     * @param url    访问地址
     * @param params url参数
     * @return URI
     */
    private static URI buildUrl(String url, Map<String, String> params) {
        URI uri = null;
        try {
            // 创建访问的地址
            URIBuilder uriBuilder = new URIBuilder(url);
            // 封装query参数
            if (params != null) {
                Set<Map.Entry<String, String>> entrySet = params.entrySet();
                for (Map.Entry<String, String> entry : entrySet) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue());
                }
            }
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            log.error("构建http请求url异常：{0}", e);
        }
        return uri;
    }

    /**
     * 获取 HttpClient
     *
     * @param url 访问地址
     * @return CloseableHttpClient
     */
    private static CloseableHttpClient wrapClient(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        if (StringUtils.isNotEmpty(url) && url.startsWith("https://")) {
            return sslClient();
        }
        return httpClient;
    }


    /**
     * Description: 封装请求头
     *
     * @param params     请求头
     * @param httpMethod 请求方法
     */
    private static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // 封装请求头
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Description: 获得响应结果
     *
     * @param httpResponse 响应结果
     * @param httpClient   http
     * @param httpMethod   请求方式1
     * @return JSONObject
     */
    private static JSONObject getHttpClientResult(CloseableHttpResponse httpResponse,
                                                  CloseableHttpClient httpClient, HttpRequestBase httpMethod) {
        JSONObject result = null;
        // 执行请求
        try {
            httpResponse = httpClient.execute(httpMethod);
            if (httpResponse != null && httpResponse.getStatusLine() != null) {
                String content = "";
                if (httpResponse.getEntity() != null) {
                    content = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
                }
                result = JSONObject.parseObject(content);
            } else {
                log.error("解析响应参数为null");
            }
        } catch (IOException e) {
            log.error("获取响应参数错误:", e);
        }
        return result;
    }

    /**
     * Description: 释放资源
     *
     * @param httpResponse 响应结果
     * @param httpClient   httpClient
     */
    private static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) {
        // 释放资源
        try {
            if (httpResponse != null) {
                httpResponse.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException e) {
            log.error("关闭IO流错误:", e);
        }

    }

}
