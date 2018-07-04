package com.johnwstump.springdemo.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Order {

	private Customer customer;
	private Set<OrderItem> items;
	
	public Order() {
	}
	
	public Order(Customer customer) {
		this.setCustomer(customer);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public void addItem(OrderItem orderItem) {
		if (items == null) {
			items = new HashSet<OrderItem>();
		}
		
		items.add(orderItem);
	}
	
	
}
