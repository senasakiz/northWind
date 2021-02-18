package com.example.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.northwind.entities.abstracts.IEntity;

import lombok.Data;


@Data
@Entity
@Table(name="orders")
public class Order implements IEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	@Column(name="customer_id")
	private String customerId;
	@Column(name="ship_country")
	private String shipCountry;
	@Column(name="ship_city")
	private String shipCity;
	@Column(name="ship_address")
	private String shipAddress;
	
	public Order( int orderId, String customerId, String shipCountry, String shipCity, String shipAddress) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.shipCountry = shipCountry;
		this.shipCity = shipCity;
		this.shipAddress = shipAddress;
	}
	
	public Order() {
		
	}

}
