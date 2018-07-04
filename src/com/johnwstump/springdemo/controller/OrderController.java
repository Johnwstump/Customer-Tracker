package com.johnwstump.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnwstump.springdemo.entity.Item;
import com.johnwstump.springdemo.entity.Order;
import com.johnwstump.springdemo.entity.OrderItem;
import com.johnwstump.springdemo.service.CustomerService;
import com.johnwstump.springdemo.service.ItemService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("orderForm")
	public String createOrderForm(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		Order order = new Order();
		order.addItem(new OrderItem(new Item("Cabbage", 5.00), 2));
		model.addAttribute("order", order);
		return "order-form";
	}
	
	@RequestMapping("showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("items", itemService.getItems());
		OrderItem item = new OrderItem();
		model.addAttribute("orderItem", item);
		return "order-item-form";
	}
}
