package com.chen.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.ssm.po.Customer;
import com.chen.ssm.po.ResponseData;
import com.chen.ssm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	/**
	 * 目前写完登录的验证
	 * 前台那边可以 用异步请求到这里
	 * 然后查看返回的数据 的size是否大于1 大于1说明有这个人
	 * 登录成功
	 * 另外还需要注意静态资源和过滤器
	 */
	@Autowired
	private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping("login")
	public  int login(HttpServletRequest request,Customer customer){
		int result= 0;
		ResponseData<Customer> response = customerService.getCustomer(customer);
		HttpSession session = request.getSession();
		if(response.getDatas().size()>0){
			session.setAttribute("customer", response.getDatas().get(0));
			result=1;
		}
		
		return result;
	}
}
