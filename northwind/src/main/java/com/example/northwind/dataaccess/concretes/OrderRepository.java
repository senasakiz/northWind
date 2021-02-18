package com.example.northwind.dataaccess.concretes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.northwind.entities.concretes.Order;


public interface OrderRepository extends JpaRepository<Order,Integer>{
	@Query(value="select cast (customer_id AS varchar(100)) from orders where order_id=:orderId",nativeQuery= true)
	String findCustomerId(@Param("orderId") Integer OrderId);

}
