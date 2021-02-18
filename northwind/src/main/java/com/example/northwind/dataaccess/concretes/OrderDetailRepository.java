package com.example.northwind.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.northwind.entities.concretes.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer>{

}
