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
			request.setCharacterEncoding("UTF-8");
			HttpSession  session = request.getSession();
			Customer customer = (Customer)session.getAttribute("customer");
			String path = request.getServletPath();
			String contextPath = request.getContextPath();
			response.setCharacterEncoding("UTF-8");
			if(customer==null&&!path.equals("/login.html")&&!path.equals("/customer/login")){
				response.sendRedirect(request.getContextPath()+"/login.html");
				return false;
			}
		return true;
	}

	
}
