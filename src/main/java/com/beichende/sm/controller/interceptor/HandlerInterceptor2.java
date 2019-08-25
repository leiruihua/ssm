/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename HandlerInterceptor1.java
 * @time 2018年7月29日 下午1:36:24
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *<简述功能>
 *<功能详细描述>
 * @see
 * @since
 */
public class HandlerInterceptor2 implements HandlerInterceptor{
	
	//进入handler方法之前执行
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	
		System.out.println("HandlerInterceptor2....preHandle");
		return true;
	}
	
	//进入handler方法之后，返回modelAndView之前执行
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		System.out.println("HandlerInterceptor2....postHandle");
	}
	
	//执行完handler方法之后执行
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {	
		System.out.println("HandlerInterceptor2....afterCompletion");
	}

}
