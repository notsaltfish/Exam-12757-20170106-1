package com.chen.ssm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chen.ssm.po.Customer;

public class LoginInterceptor extends HandlerInterceptorAdapter{



	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			HttpSession  session = request.getSession();
			Customer customer = (Customer)session.getAttribute("customer");
			String path = request.getServletPath();
			String contextPath = request.getContextPath();
			if(customer==null&&!path.equals("/login.html")&&!path.equals("/login")){
				response.sendRedirect(request.getContextPath()+"/login.html");
			}
		return super.preHandle(request, response, handler);
	}

	
}
