package com.johnwstump.springdemo.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnwstump.springdemo.dao.CustomerDAO;
import com.johnwstump.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
