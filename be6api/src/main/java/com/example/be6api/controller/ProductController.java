package com.example.be6api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.be6api.model.Product;
import com.example.be6api.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> retrieveAllProduct() {
		return productService.getAllProduct();
	}
	
	@GetMapping("/products/{id}")
	public Product retrieveProduct(@PathVariable int id) {
		return productService.findEachProduct(id);
	}
	
	@GetMapping("/products/")
	public List<Product> retrieveProductByCategory(@RequestParam(value = "category", required = false) String category) {
		return productService.getProductByCategory(category);
	}
	
	@PostMapping("/products")
	public void createProduct(@RequestBody Product product) {
		@SuppressWarnings("unused")
		Product savedProduct = productService.saveProduct(product);
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Product product) {
		@SuppressWarnings("unused")
		Product updatedProduct = productService.saveProduct(product);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.delete(id);
	}
}
