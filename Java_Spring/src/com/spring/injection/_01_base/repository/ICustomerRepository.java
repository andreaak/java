package com.spring.injection._01_base.repository;

import java.util.List;

import com.spring.injection._01_base.model.Customer;

public interface ICustomerRepository {

	List<Customer> findAll();
}