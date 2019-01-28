package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	private static final String START_TIME = "startTime";
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		request.setAttribute(START_TIME, System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		long startTime = (long)request.getAttribute(START_TIME);
		LOG.info("Reques url peticion:'"+request.getRequestURI()+"' time: "+(System.currentTimeMillis()-startTime)+"ms");
		super.afterCompletion(request, response, handler, ex);
	}
	
}
