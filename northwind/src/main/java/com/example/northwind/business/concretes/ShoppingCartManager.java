package com.example.northwind.business.concretes;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IShoppingCartService;
import com.example.northwind.dataaccess.concretes.ShoppingCartRepository;
import com.example.northwind.entities.concretes.ShoppingCart;

@Service
@Transactional
public class ShoppingCartManager implements IShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public List<ShoppingCart> getAll() {
		return shoppingCartRepository.findAll();
	}

	@Override
	public ShoppingCart addToCart(ShoppingCart shoppingCart) throws Exception {
		String customerId=shoppingCart.getCustomerId();
		int productId=shoppingCart.getProductId();
		int quantity=shoppingCart.getQuantity();
		
		List<Integer> cartList=shoppingCartRepository.findProduct(productId, customerId);
		
		if(cartList.isEmpty()) {
			return shoppingCartRepository.save(shoppingCart);
		}
		else {
			int cartId=cartList.get(0);
			int updatedQuantity=quantity+1;
			shoppingCartRepository.updateQuantity(updatedQuantity, cartId);
			return shoppingCart;
		}
		
	}

	@Override
	public Optional<ShoppingCart> findById(ShoppingCart shoppingCart) {
		int cartId=shoppingCart.getCartId();
		return shoppingCartRepository.findById(cartId);
	}

	@Override
	public List<ShoppingCart> findByCustomerId(String CustomerId) {
		return shoppingCartRepository.findCustomer(CustomerId);
	}

	@Override
	public ShoppingCart deleteItemFromCart(ShoppingCart shoppingCart,ShoppingCart shoppingCarts) throws Exception {
		int cartId=shoppingCart.getCartId();
		int deleteItem=1;
		
		ShoppingCart updateToQuantity=shoppingCartRepository.findById(cartId).orElseThrow(() -> new Exception("No product with id:" + cartId));
		
		if(deleteItem > 0 && shoppingCart.getQuantity() >= deleteItem){
			updateToQuantity.setQuantity(shoppingCart.getQuantity() - deleteItem);
		
		}
		else {
			throw new IllegalArgumentException("Sepetinizde silmek istediginiz kadar urun bulunmamaktadir !");
		}
		ShoppingCart updatedQuantity=shoppingCartRepository.save(updateToQuantity);
		return updatedQuantity;
	
}
}
