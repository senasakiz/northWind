package com.example.northwind.dataaccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.northwind.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	@Query(value="select count(product_name) FROM products where category_id =:categoryNumber group by category_id", nativeQuery= true)
    int SizeOfCategory(@Param("categoryNumber")  Integer CategoryId);

}
