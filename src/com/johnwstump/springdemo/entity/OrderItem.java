package com.johnwstump.springdemo.entity;

import org.springframework.stereotype.Component;

@Component
public class OrderItem {

	private Item item;
	private double quantity = 0;
	private double cost = 0;
	
	public OrderItem() {
		
	}

	public OrderItem(Item item, double quantity) {
		this.item = item;
		this.quantity = quantity;
		calculateCost();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
		calculateCost();
	}

	public String getName() {
		return item.getName();
	}
	
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
		calculateCost();
	}
	
	private void calculateCost() {
		cost = quantity * item.getPrice();
	}
	
	public double getCost() {
		return this.cost;
	}
}
