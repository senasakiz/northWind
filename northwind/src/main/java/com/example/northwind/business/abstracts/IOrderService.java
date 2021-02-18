package com.example.northwind.business.abstracts;

import java.util.List;


import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetail;

public interface IOrderService {
	List<Order> getAll();
	List<OrderDetail> getOrderDetails();
	Order addToOrder(Order order);
	OrderDetail addToOrderDetail(OrderDetail orderDetail);
	

}
