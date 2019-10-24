package com.xxl.api.admin.filter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component("sessionCheckFilter")
public class SessionCheckFilter implements Filter {

	protected Logger logger = Logger.getLogger(getClass());

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(true);
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD"); // or
		httpResponse.setHeader("Access-Control-Allow-Headers",
				"x-requested-with, Content-Type, Token, deviceType, MUserAgent, Authorization, access-token"); // or

		logger.debug("\n===================filter begin===================");
		String uri = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
		logger.debug(uri + "\t" + contextPath);
		String referer = httpRequest.getHeader("referer");
		logger.debug("前一个链接是：" + referer);
		String method = httpRequest.getMethod();
		logger.debug("请求方法是：\n" + method);
		String deviceType = httpRequest.getHeader("deviceType");
		logger.debug("获取到的deviceType是：\n" + deviceType);
		logger.debug("\n===================filter end===================");

		if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) { // OPTIONS 预请求直接返回
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
