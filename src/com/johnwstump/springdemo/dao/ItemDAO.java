package com.johnwstump.springdemo.dao;

import java.util.List;

import com.johnwstump.springdemo.entity.Customer;
import com.johnwstump.springdemo.entity.Item;

public interface ItemDAO {
	public List<Item> getItems();

	public void saveItem(Item item);

	public Item getItem(int id);

	public void deleteItem(int id);
}
