package com.wangziqing.goubige.springMVC.utils;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharFilter implements Filter
{
    private String targetEncoding;
    /**
     *
     * {还原到原始编码格式}
     *
     * @author:LJ
     */
    public void destroy()
    {
        targetEncoding = null;
    }
    /**
     *
     * {对请求和响应字符集过滤}
     *
     * @param srequest
     * @param sresponse
     * @param chain
     * @throws IOException
     * @throws ServletException
     * @author:LJ
     */
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain) throws IOException,
            ServletException
    {
        HttpServletRequest request = (HttpServletRequest) srequest;
        request.setCharacterEncoding(targetEncoding);
        sresponse.setContentType("text/html;charset=GBK");
        chain.doFilter(srequest, sresponse); ///派发请求
    }
    /**
     *
     * {初始化字符集编码格式}
     *
     * @param config
     * @throws ServletException
     * @author:LJ
     */
    public void init(FilterConfig config) throws ServletException
    {
        targetEncoding = config.getInitParameter("encoding");
    }
}