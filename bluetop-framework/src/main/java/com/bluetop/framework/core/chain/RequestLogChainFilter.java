/**
 * 文 件 名:  LogChainFilter
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.bluetop.framework.core.cons.Constans.TRANCE_ID;
import static com.bluetop.framework.core.context.RequestHeader.X_REQUEST_ID;

/**
 * <日志请求链>
 *
 * @author zping
 * @version 2018/4/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Slf4j
@Order(Integer.MAX_VALUE - 9)
@WebFilter(urlPatterns = {"/api/*", "/*"}, filterName = "RequestLogChainFilter")
public class RequestLogChainFilter implements Filter
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger (RequestLogChainFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		LOGGER.debug ("【RequestLogChainFilter】 Logger Chain init ...");
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String traceID = request.getHeader (X_REQUEST_ID.getName());
		ThreadContext.put (TRANCE_ID, traceID);
		filterChain.doFilter (request, response);
		ThreadContext.clearAll ();
	}
	
	@Override
	public void destroy()
	{
		LOGGER.debug ("【RequestLogChainFilter】 Logger Chain destroy ...");
	}
}
