package com.chen.ssm.mapper;

import java.util.List;

import com.chen.ssm.po.Customer;

public interface CustomerMapper {
	List<Customer> selectByCustomer(Customer customer);
}
