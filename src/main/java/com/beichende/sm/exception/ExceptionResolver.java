/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename ExceptionResolver.java
 * @time 2018年7月25日 下午11:04:36
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 *<简述功能>异常处理
 *<功能详细描述>
 * @see
 * @since
 */
public class ExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		String exceptionMessage = null;
		if(ex instanceof ClassNotFoundException){
			exceptionMessage = "发生类找不到错误";
		}else{
			exceptionMessage = "未知错误";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exceptionMessage",exceptionMessage);
		modelAndView.setViewName("/error");
		return modelAndView;
	}

}
