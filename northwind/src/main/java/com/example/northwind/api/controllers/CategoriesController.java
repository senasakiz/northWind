package com.example.northwind.api.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.entities.concretes.Category;

@RestController
@RequestMapping("/api/v1")
public class CategoriesController {
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAll(){
		return categoryService.getAll();	
	}
	
	@GetMapping("/categories/{id}")
	public Optional<Category> getById(@PathVariable(value="id")Category category){
		return categoryService.getById(category);
	}	
	
	@PostMapping("/categories")
	public Category add(@RequestBody Category category) {
		return categoryService.add(category);
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> update(@PathVariable(value="id")Integer id,@RequestBody Category category) throws Exception{
		return categoryService.update(id,category);
	}
	
	@DeleteMapping("/categories/{id}")
	public Map<String,Boolean> delete(@PathVariable(value="id") Integer id,@RequestBody Category category) throws Exception{
		return categoryService.delete(id,category);
	}

}
