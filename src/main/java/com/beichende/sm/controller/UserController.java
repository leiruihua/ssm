/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename UserController.java
 * @time 2018年7月15日 下午3:37:17
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.beichende.sm.pojo.MUser;

/**
 *<简述功能>通过原始的xml配置方式
 *<功能详细描述>
 *			映射器:	
 *					1.BeanNameUrlHandlerMapping 
 *				   	2.SimpleUrlHandlerMapping
 *			 处理器:
 *					SimpleControllerHandlerAdapter(实现Controller)
 * @see
 * @since
 */
public class UserController implements Controller{
	//返回ModelAndView的形式
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MUser muser = new MUser();
		muser.setUserName("典狱司");
		List<MUser> list = new ArrayList<MUser>();
		list.add(muser);
		ModelAndView modelAndView = new ModelAndView();
		//将数据模型加进去
		modelAndView.addObject("list",list);
		//将视图加进去
		modelAndView.setViewName("/index");
		
		System.out.println("Controller");
		return modelAndView;
	}
	
}
