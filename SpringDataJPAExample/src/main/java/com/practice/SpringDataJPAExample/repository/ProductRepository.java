package com.practice.SpringDataJPAExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.SpringDataJPAExample.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// Custom query method to find products by name
	List<Product> findByName(String name);
	
	// Custom query to get all products
    @Query("SELECT p FROM Product p")
    List<Product> getAllProducts();

    // Custom query to get products by name
    @Query("SELECT p FROM Product p WHERE p.name = :productName")
    List<Product> getProductsByName(@Param("productName") String productName);

    // Native query to get all products
    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> getAllProductsNativeQuery();
	
	
}
