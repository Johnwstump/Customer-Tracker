package com.johnwstump.webcustomertracker.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnwstump.webcustomertracker.dao.CustomerDAO;
import com.johnwstump.webcustomertracker.entity.Customer;
import com.johnwstump.webcustomertracker.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

	@Transactional
	@Override
	public List<Customer> searchCustomers(String searchTerm) {
		return customerDAO.searchCustomers(searchTerm);
	}

}
