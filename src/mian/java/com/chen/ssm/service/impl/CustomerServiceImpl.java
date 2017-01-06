package com.chen.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.ssm.mapper.CustomerMapper;
import com.chen.ssm.po.Customer;
import com.chen.ssm.po.ResponseData;
import com.chen.ssm.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public ResponseData<Customer> getCustomer(Customer customer) {
		ResponseData response = new ResponseData();
		response.setDatas(customerMapper.selectByCustomer(customer));

		return response;
	}

}
