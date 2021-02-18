package com.example.northwind.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.northwind.entities.concretes.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
	@Query(value="SELECT cart_id from shopping_cart where product_id=?1 and customer_id=?2", nativeQuery= true)
	List<Integer> findProduct(Integer productId, String customerId);
	
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE shopping_cart SET quantity=?1 WHERE cart_id=?2",nativeQuery= true)
	void updateQuantity(Integer quantity, Integer cartId);
	
	@Query(value="SELECT * FROM shopping_cart where customer_id =?1", nativeQuery= true)
	List<ShoppingCart> findCustomer(String customerId);
	
	@Query(value="DELETE FROM SHOPPING_CART WHERE CUSTOMER_ID=?1 AND PRODUCT_ID=?2",nativeQuery= true)
	void BuyCart(String customerId, Integer productId);
	
	
}
