package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Optional;


import com.example.northwind.entities.concretes.ShoppingCart;

public interface IShoppingCartService {
	List<ShoppingCart> getAll();
	ShoppingCart addToCart(ShoppingCart shoppingCart)throws Exception;
	Optional<ShoppingCart> findById(ShoppingCart shoppingCart);
	List<ShoppingCart> findByCustomerId(String CustomerId);
	ShoppingCart deleteItemFromCart(ShoppingCart shoppingCart,ShoppingCart shoppingCarts) throws Exception;

}
