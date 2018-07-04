package com.johnwstump.springdemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnwstump.springdemo.dao.ItemDAO;
import com.johnwstump.springdemo.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Item> getItems() {
		Session session = sessionFactory.getCurrentSession();
		List<Item> items = session.createQuery("FROM Item", Item.class).getResultList();
		return items;
	}

	@Override
	public void saveItem(Item item) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(item); 
	}

	@Override
	public Item getItem(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Item.class, id);
	}

	@Override
	public void deleteItem(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Item.class, id));
	}

}
