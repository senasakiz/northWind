package com.example.northwind.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetail;

@RestController
@RequestMapping("/api/v1")
public class OrdersController {
	@Autowired
	IOrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> getAll(){
		return orderService.getAll();
	}
	
	@GetMapping("/order_details")
	public List<OrderDetail> getOrderDetails(){
		return orderService.getOrderDetails();
	}
	
	@PostMapping("/orders")
	public Order addToOrder(@RequestBody Order order) {
		return orderService.addToOrder(order);
	}
	
	@PostMapping("/order_details")
	public OrderDetail addToOrder(@RequestBody OrderDetail orderDetail) {
		return orderService.addToOrderDetail(orderDetail);
	}
	

}
