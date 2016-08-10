package com.spring.injection._01_base.service;

import java.util.List;

import com.spring.injection._01_base.model.Customer;

public interface ICustomerService {

	List<Customer> findAll();

	String getDescription();
}