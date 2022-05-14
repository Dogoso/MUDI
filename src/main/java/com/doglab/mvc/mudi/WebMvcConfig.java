package com.doglab.mvc.mudi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.doglab.mvc.mudi.interceptors.AcessCountHandlerInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private AcessCountHandlerInterceptor acessHandler;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(acessHandler);
	}
	
}
