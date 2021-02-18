package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.dataaccess.concretes.CategoryRepository;
import com.example.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> getById(Category category) {
		int id=category.getId();
		return categoryRepository.findById(id);
	}

	@Override
	public Category add(Category category) {
		System.out.println(category.getCategoryName());
		return categoryRepository.save(category);
	}

	@Override
	public ResponseEntity<Category> update(Integer id, Category category) throws Exception {
		Category categoryToUpdate=categoryRepository.findById(id).orElseThrow(()->new Exception("No category with id:"+id));
		
		categoryToUpdate.setCategoryName(category.getCategoryName());
		categoryToUpdate.setDescription(category.getDescription());
		categoryRepository.save(categoryToUpdate);
		
		Category updatedCategory=categoryRepository.save(categoryToUpdate);
		return ResponseEntity.ok(updatedCategory);
	}

	@Override
	public Map<String, Boolean> delete(Integer id,Category category) throws Exception {
		Category categoryDelete=categoryRepository.findById(id).orElseThrow(()->new Exception("No category with id:"+id));
		
		categoryRepository.delete(categoryDelete);
		Map<String,Boolean> response=new HashMap<>();
		response.put("silindi",Boolean.TRUE);
		return response;
	}

}
