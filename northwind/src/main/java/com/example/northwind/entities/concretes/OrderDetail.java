package com.example.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.northwind.entities.abstracts.IEntity;

import lombok.Data;

@Data
@Entity
@Table(name="order_details")
@IdClass(CompositeKey.class)
public class OrderDetail implements IEntity{
	
	
	@Id
	@Column(name="order_id")
	private int orderId;
	@Id
	@Column(name="product_id")
	private int productId;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="quantity")
	private int quantity;
	@Column(name="discount")
	private double discount;
	
	
	public OrderDetail(int orderId, int productId, double unitPrice, int quantity, double discount) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
	}
	
	public OrderDetail() {
		
	}

}
