package com.johnwstump.springdemo.service;

import java.util.List;

import com.johnwstump.springdemo.entity.Item;

public interface ItemService {

	public List<Item> getItems();
	
	public Item getItem(int id);
	
	public void saveItem(Item item);
	
	public void deleteItem(int id);

	public void deleteItem(Item item);
}
