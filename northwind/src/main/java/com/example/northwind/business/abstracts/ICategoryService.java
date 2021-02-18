package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.northwind.entities.concretes.Category;

public interface ICategoryService {
	List<Category> getAll();
	Optional<Category> getById(Category category);
	public Category add(Category category);
	public ResponseEntity<Category> update(Integer id,Category category) throws Exception;
	public Map<String,Boolean> delete(Integer id,Category category) throws Exception;

}
