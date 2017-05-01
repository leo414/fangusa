package com.hhh.fangusa.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public class SpringMvcUtils extends HandlerInterceptorAdapter {
    /**
     * content-type 文本类型
     */
    public static final String TEXT_TYPE = "text/plain";
    /**
     * content-type json类型
     */
    public static final String JSON_TYPE = "application/json";

    //-- content-type 常量定义 --//
    /**
     * content-type xml类型
     */
    public static final String XML_TYPE = "text/xml";
    /**
     * content-type 文本html类型
     */
    public static final String HTML_TYPE = "text/html";
    /**
     * content-type js类型
     */
    public static final String JS_TYPE = "text/javascript";
    //-- header 常量定义 --//
    private static final String HEADER_ENCODING = "encoding";
    private static final String HEADER_NOCACHE = "no-cache";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final boolean DEFAULT_NOCACHE = true;
    private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<>();

    /**
     * 取得HttpRequest的简化函数.
     */
    public static HttpServletRequest getRequest() {
        return requestThreadLocal.get();
    }

    /**
     * 取得HttpRequest中Parameter的简化方法.
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 取得HttpResponse的简化函数.
     */
    public static HttpServletResponse getResponse() {
        return responseThreadLocal.get();
    }

    /**
     * 直接输出内容的简便函数.
     * <p>
     * eg.
     * render("text/plain", "hello", "encoding:GBK");
     * render("text/plain", "hello", "no-cache:false");
     * render("text/plain", "hello", "encoding:GBK", "no-cache:false");
     *
     * @param headers 可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
     */
    public static void render(final String contentType, final String content, final String... headers) {
        HttpServletResponse response = initResponseHeader(contentType, headers);
        try {
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    //-- 绕过jsp/freemaker直接输出文本的函数 --//

    /**
     * 直接输出文本.
     *
     * @see #render(String, String, String...)
     */
    public static void renderText(final String text, final String... headers) {
        render(TEXT_TYPE, text, headers);
    }

    /**
     * 直接输出HTML.
     *
     * @see #render(String, String, String...)
     */
    public static void renderHtml(final String html, final String... headers) {
        render(HTML_TYPE, html, headers);
    }

    /**
     * 直接输出XML.
     *
     * @see #render(String, String, String...)
     */
    public static void renderXml(final String xml, final String... headers) {
        render(XML_TYPE, xml, headers);
    }

    /**
     * 直接输出JSON.
     *
     * @param jsonString json字符串.
     * @see #render(String, String, String...)
     */
    public static void renderJson(final String jsonString, final String... headers) {
        render(JSON_TYPE, jsonString, headers);
    }

    /**
     * 直接输出支持跨域Mashup的JSONP.
     */
    public static void renderJsonp(final String callbackName, final String jsonString, final String... headers) {
        String result = new StringBuilder().append(callbackName).append("(").append(jsonString).append(");").toString();
        //渲染Content-Type为javascript的返回内容,输出结果为javascript语句, 如callback197("{html:'Hello World!!!'}");
        render(JS_TYPE, result, headers);
    }

    /**
     * 分析并设置contentType与headers.
     */
    private static HttpServletResponse initResponseHeader(final String contentType, final String... headers) {
        //分析headers参数
        String encoding = DEFAULT_ENCODING;
        boolean noCache = DEFAULT_NOCACHE;
        for (String header : headers) {
            String headerName = StringUtils.substringBefore(header, ":");
            String headerValue = StringUtils.substringAfter(header, ":");

            if (StringUtils.equalsIgnoreCase(headerName, HEADER_ENCODING)) {
                encoding = headerValue;
            } else if (StringUtils.equalsIgnoreCase(headerName, HEADER_NOCACHE)) {
                noCache = Boolean.parseBoolean(headerValue);
            } else {
                throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
            }
        }

        HttpServletResponse response = getResponse();

        //设置headers参数
        String fullContentType = contentType + ";charset=" + encoding;
        response.setContentType(fullContentType);
        if (noCache) {
            setNoCacheHeader(response);
        }
        return response;
    }

    /**
     * 设置客户端无缓存Header
     *
     * @param response HttpServletResponse
     */
    public static void setNoCacheHeader(HttpServletResponse response) {
        //Http 1.0 header
        response.setDateHeader("Expires", 0);
        response.addHeader("Pragma", "no-cache");
        //Http 1.1 header
        response.setHeader("Cache-Control", "no-cache");
    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        requestThreadLocal.set(request);
        responseThreadLocal.set(response);
        return true;
    }
}


