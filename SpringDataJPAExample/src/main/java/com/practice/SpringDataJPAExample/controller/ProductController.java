package com.practice.SpringDataJPAExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.practice.SpringDataJPAExample.entities.Product;
import com.practice.SpringDataJPAExample.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping("/add")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		// Ensure the product id in the path matches the id in the request body
		if (!id.equals(product.getId())) {
			throw new IllegalArgumentException("Product ID in path must match the ID in the request body");
		}
		return productService.updateProduct(product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

	// Custom endpoint to find products by name
	@GetMapping("/byName/{name}")
	public List<Product> getProductsByName(@PathVariable String name) {
		return productService.getProductsByName(name);
	}
	
	@GetMapping("/allNative")
    public List<Product> getAllProductsNativeQuery() {
        return productService.getAllProductsNativeQuery();
    }
}
