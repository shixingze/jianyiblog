package com.jianyi.utils;

import com.jianyi.auth.constats.AuthConstats;
import com.jianyi.jianyiblog.common.utils.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class ServletUtils {

    public static HttpServletRequest request() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }

    public static HttpServletResponse response() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        return response;
    }


    public static void setToken(String token) {
        HttpServletResponse httpServletResponse = response();
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "Authorization");
        httpServletResponse.setHeader(AuthConstats.TOKEN_KEY, token);
    }

    public static String getToken() {
        HttpServletRequest request = request();
        String token = request.getHeader(AuthConstats.TOKEN_KEY);
        return token;
    }

//    public static String domain() {
//        InetAddress ip;
//        String hostAddress = "";
//        try {
//            ip = InetAddress.getLocalHost();
//            hostAddress = ip.getHostAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        Environment environment = SpringContextUtil.getBean(Environment.class);
//        Integer port = environment.getProperty("server.port", Integer.class);
//        return "http://" + hostAddress + ":" + port;
//    }

    /**
     * 获取String参数
     */
    public static String getParameter(String name)
    {
        return getRequest().getParameter(name);
    }

//    /**
//     * 获取String参数
//     */
//    public static String getParameter(String name, String defaultValue)
//    {
//        return Convert.toStr(getRequest().getParameter(name), defaultValue);
//    }

//    /**
//     * 获取Integer参数
//     */
//    public static Integer getParameterToInt(String name)
//    {
//        return Convert.toInt(getRequest().getParameter(name));
//    }

//    /**
//     * 获取Integer参数
//     */
//    public static Integer getParameterToInt(String name, Integer defaultValue)
//    {
//        return Convert.toInt(getRequest().getParameter(name), defaultValue);
//    }

//    /**
//     * 获取Boolean参数
//     */
//    public static Boolean getParameterToBool(String name)
//    {
//        return Convert.toBool(getRequest().getParameter(name));
//    }

//    /**
//     * 获取Boolean参数
//     */
//    public static Boolean getParameterToBool(String name, Boolean defaultValue)
//    {
//        return Convert.toBool(getRequest().getParameter(name), defaultValue);
//    }

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest()
    {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取response
     */
    public static HttpServletResponse getResponse()
    {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession()
    {
        return getRequest().getSession();
    }

    public static ServletRequestAttributes getRequestAttributes()
    {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 将字符串渲染到客户端
     *
     * @param response 渲染对象
     * @param string 待渲染的字符串
     * @return null
     */
    public static String renderString(HttpServletResponse response, String string)
    {
        try
        {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  下载文件方法头
     * @param response
     * @param fileName
     * @throws UnsupportedEncodingException
     */
    public static void setFileDownLoad(HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
        response.setContentType("application/x-download");
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setCharacterEncoding("UTF-8");
         response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
    }
    /**
     * 是否是Ajax异步请求
     *
     * @param request
     */
    public static boolean isAjaxRequest(HttpServletRequest request)
    {
        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1)
        {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1)
        {
            return true;
        }

        String uri = request.getRequestURI();
        if (StringUtils.inStringIgnoreCase(uri, ".json", ".xml"))
        {
            return true;
        }

        String ajax = request.getParameter("__ajax");
        if (StringUtils.inStringIgnoreCase(ajax, "json", "xml"))
        {
            return true;
        }
        return false;
    }
}
