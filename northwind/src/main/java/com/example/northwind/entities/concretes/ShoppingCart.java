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
@Table(name="shopping_cart")
public class ShoppingCart implements IEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Integer cartId;
	@Column(name="customer_id")
	private String customerId;
	@Column(name="product_id")
	private Integer productId;
	@Column(name="quantity")
	private int quantity;
}
