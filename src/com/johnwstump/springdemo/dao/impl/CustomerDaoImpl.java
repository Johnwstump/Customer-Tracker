package com.johnwstump.springdemo.dao.impl;

import java.util.List;

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
		
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("DELETE FROM Customer WHERE id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String searchTerm) {
		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query;
		/* If the search term is empty or null retrieve all names*/
		if (searchTerm.trim().isEmpty() || searchTerm == null) {
			query = session.createQuery("FROM Customer order by lastName");
			
		}
		
		/* Retrieve customers whose first name, last name, or email start with the string */
		else {
			query = session.createQuery("FROM Customer WHERE LOWER(firstName) LIKE :searchTerm OR LOWER(lastName) LIKE :searchTerm OR LOWER(email) LIKE :searchTerm ORDER BY lastName", Customer.class);
			query.setParameter("searchTerm", searchTerm + "%");
		}
		
		return query.getResultList();
	}

}
