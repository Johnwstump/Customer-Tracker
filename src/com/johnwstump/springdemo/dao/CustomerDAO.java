package com.johnwstump.springdemo.dao;

import java.util.List;

import com.johnwstump.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
}
