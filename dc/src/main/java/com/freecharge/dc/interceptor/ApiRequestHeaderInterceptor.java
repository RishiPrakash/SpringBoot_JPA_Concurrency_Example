package com.freecharge.dc.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.freecharge.dc.util.RequestUtil;

@Component("ApiRequestHeaderInterceptor")
@Scope("prototype")
public class ApiRequestHeaderInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		RequestUtil.initializeUserContext(request.getHeader("requestID"), request.getHeader("channel"), request.getHeader("webJourney"));
		return true;
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("****************************Request Audit*************************");
		System.out.println("RequestId = "+RequestUtil.getCurrentRequestId());
		System.out.println("All headers = "+RequestUtil.getHeaderInfo());
		System.out.println("****************************Request Audit*************************");

		RequestUtil.clearUserContext();
	}
	
}
