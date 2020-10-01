package com.freecharge.dc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationWebConfiguration implements WebMvcConfigurer {
	@Autowired
	@Qualifier("ApiRequestHeaderInterceptor")
	private com.freecharge.dc.interceptor.ApiRequestHeaderInterceptor ApiRequestHeaderInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(ApiRequestHeaderInterceptor).addPathPatterns("/api/**");
	}
}
