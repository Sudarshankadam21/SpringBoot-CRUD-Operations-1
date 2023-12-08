package com.practice.SpringDataJPAExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.SpringDataJPAExample.entities.Product;
import com.practice.SpringDataJPAExample.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// Create
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// Read
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	// Update
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	// Delete
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	// Custom query method to find products by name
	public List<Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}
	
	

    public List<Product> getAllProducts1() {
        return productRepository.getAllProducts();
    }

    public List<Product> getProductsByName1(String productName) {
        return productRepository.getProductsByName(productName);
    }

    public List<Product> getAllProductsNativeQuery() {
        return productRepository.getAllProductsNativeQuery();
    }
	
	
	
	
}
