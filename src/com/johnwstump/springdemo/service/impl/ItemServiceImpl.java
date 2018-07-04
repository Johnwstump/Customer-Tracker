package com.johnwstump.springdemo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnwstump.springdemo.dao.ItemDAO;
import com.johnwstump.springdemo.dao.impl.ItemDAOImpl;
import com.johnwstump.springdemo.entity.Item;
import com.johnwstump.springdemo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO = new ItemDAOImpl();
	
	@Transactional
	@Override
	public List<Item> getItems() {
		return itemDAO.getItems();
	}

	@Transactional
	@Override
	public Item getItem(int id) {
		return itemDAO.getItem(id);
	}
	
	@Transactional
	@Override
	public void saveItem(Item item) {
		itemDAO.saveItem(item);
	}
	
	@Transactional
	@Override
	public void deleteItem(int id) {
		itemDAO.deleteItem(id);
	}
	
	@Transactional
	@Override
	public void deleteItem(Item item) {
		itemDAO.deleteItem(item.getId());
	}

}
