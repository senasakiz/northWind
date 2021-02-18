package com.example.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IShoppingCartService;
import com.example.northwind.entities.concretes.ShoppingCart;

@RestController
@RequestMapping("/api/v1")

public class ShoppingCartsController {
	@Autowired
	IShoppingCartService shoppingCartService;
	
	
	@GetMapping("/shopping_cart")
	public List<ShoppingCart> getAll(){
		return shoppingCartService.getAll();
	}
	
	@GetMapping("/shopping_cart/name/{customer_id}")
	public List<ShoppingCart> getByCustomerId(@PathVariable(value="customer_id", required = true) String customerId)throws Exception{
		
		List<ShoppingCart> list = shoppingCartService.findByCustomerId(customerId);
		
		if(list == null) {
            System.out.println("Kullanıcı bulunamadı!");
        }
        return shoppingCartService.findByCustomerId(customerId);
	}
	
	@GetMapping("/shopping_cart/{cart_id}")
	public ShoppingCart getById(@PathVariable(value ="cart_id") ShoppingCart shoppingCart) throws Exception{
		return shoppingCartService.findById(shoppingCart).orElseThrow(()->new Exception ("no cart with"+shoppingCart.getCartId()));
		
	}
	
	@PostMapping("/shopping_cart")
	public ShoppingCart addToCart(@RequestBody ShoppingCart shoppingCart)throws Exception{
		return shoppingCartService.addToCart(shoppingCart);
	}
	
	@PutMapping("/shopping_cart/{cart_id}")
	public ShoppingCart deleteItem(@PathVariable(value ="cart_id") ShoppingCart shoppingCart,@RequestBody ShoppingCart shoppingCarts)throws Exception {
		return shoppingCartService.deleteItemFromCart(shoppingCart,shoppingCarts);
		
	}

}
