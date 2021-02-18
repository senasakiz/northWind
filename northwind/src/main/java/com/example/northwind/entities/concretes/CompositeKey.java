package com.example.northwind.entities.concretes;

import java.io.Serializable;

import javax.persistence.Column;
@SuppressWarnings("serial")
public class CompositeKey implements Serializable{
	
	
	private int orderId;
	private int productId;
	
	public CompositeKey() {
		
	}
	
	public CompositeKey(int orderId, int productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}

}
