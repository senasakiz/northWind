package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataaccess.concretes.ProductRepository;
import com.example.northwind.entities.concretes.Product;

@Service
public class ProductManager implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getById(Product product) {
		int id=product.getId();
		return productRepository.findById(id);
	}

	@Override
	public Product add(Product product) {
		int productNameLength=product.getProductName().length();
		int categoryId=product.getCategoryId();
		int SizeOfCategory=productRepository.SizeOfCategory(categoryId);
		
		
		System.out.println(product.getProductName());
		if(productNameLength>2 && SizeOfCategory<10) {
			System.out.println("Kayıt başarılı!");
			return productRepository.save(product);
		}
		else {
			System.out.println("Ürün ekleme koşullarına uymadığı için eklenemedi");
			return product;
		}
	}

	@Override
	public ResponseEntity<Product> update(Integer id,Product product) throws Exception {
		
		Product productToUpdate=productRepository.findById(id).orElseThrow(()->new Exception("No product with id:"+id));

		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		productRepository.save(productToUpdate);
		
		
		Product updatedProduct=productRepository.save(productToUpdate);
		return ResponseEntity.ok(updatedProduct);
	}


	@Override
	public Map<String, Boolean> delete(Integer id,Product product) throws Exception {
		Product productDelete=productRepository.findById(id).orElseThrow(()->new Exception("no product with id"+id));
		productRepository.delete(productDelete);
		Map<String,Boolean> response=new HashMap<>();
		response.put("silindi",Boolean.TRUE);
		return response;
	}

}
