package com.chen.ssm.service;

import com.chen.ssm.po.Customer;
import com.chen.ssm.po.ResponseData;


public interface CustomerService {
		ResponseData<Customer> getCustomer(Customer customer);
}
