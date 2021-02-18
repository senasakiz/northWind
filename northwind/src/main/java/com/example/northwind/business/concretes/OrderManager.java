package com.example.northwind.business.concretes;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.dataaccess.concretes.OrderDetailRepository;
import com.example.northwind.dataaccess.concretes.OrderRepository;
import com.example.northwind.dataaccess.concretes.ShoppingCartRepository;
import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetail;

@Transactional
@Service
public class OrderManager implements IOrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@Override
	public List<OrderDetail> getOrderDetails() {
		return orderDetailRepository.findAll();
	}

	@Override
	public Order addToOrder(Order order) {
		return orderRepository.save(order);
	}


	
	 @Override 
	 public OrderDetail addToOrderDetail(OrderDetail orderDetail) {
	 orderDetailRepository.save(orderDetail); 
	 int orderProductId=orderDetail.getProductId(); 
	 int orderId=orderDetail.getOrderId(); 
	 String customerId=orderRepository.findCustomerId(orderId);
	 shoppingCartRepository.BuyCart(customerId, orderProductId);
	  
	  return orderDetail;
	  
	  }
	 

}
