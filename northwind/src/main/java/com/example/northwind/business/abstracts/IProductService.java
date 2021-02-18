package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.northwind.entities.concretes.Product;

public interface IProductService {
	List<Product> getAll() ;
	Optional<Product> getById(Product product);
	public Product add(Product product);
	public ResponseEntity<Product> update(Integer id,Product product) throws Exception;
	public Map<String,Boolean> delete(Integer id,Product product) throws Exception;

}
