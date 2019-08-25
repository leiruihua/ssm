/**
 * @author 雷瑞铧
 * @version 1.0.0
 * @filename UserController.java
 * @time 2018年7月15日 下午3:37:17
 * @copyright(C) 2018 深圳市北辰德科技股份有限公司
 */
package com.beichende.sm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.beichende.sm.pojo.MUser;

/**
 *<简述功能>
 *<功能详细描述>
 *			映射器:	
 *					1.BeanNameUrlHandlerMapping 
 *				   	2.SimpleUrlHandlerMapping
 *			 处理器:
 *					HttpRequestHandlerAdapter(实现HttpRequestHandler接口)
 * @see
 * @since
 */
public class UserController2 implements HttpRequestHandler{
	//无返回值的形式
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MUser muser = new MUser();
		muser.setUserName("典狱司");
		List<MUser> list = new ArrayList<MUser>();
		list.add(muser);
		//设置模型数据
		request.setAttribute("list",list);
		//设置转发视图
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		System.out.println("Controller2");
		/*通过此方法可以通过修改response来设置响应的数据格式，比如json数据
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write("json串");
		*/
	}

	
	
}
