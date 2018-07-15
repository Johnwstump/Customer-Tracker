package com.johnwstump.webcustomertracker.dao;

import java.util.List;

import com.johnwstump.webcustomertracker.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String searchTerm);

}
