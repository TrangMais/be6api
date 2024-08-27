package com.example.be6api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.be6api.model.Product;

@Component
public class ProductService {
	private static List<Product> products = new ArrayList<Product>();
	private static int productCount = 4;
	
	static {
		products.add(new Product(1, "Banh mi", 10, "Food"));
		products.add(new Product(2, "Tra da", 2, "Drink"));
		products.add(new Product(3, "Banh bao", 15, "Food"));
		products.add(new Product(4, "Tra sua", 20, "Drink"));
	}
	
	public List<Product> getAllProduct(){
		return products;
	}
	
	public Product findEachProduct(int id) {
		for(Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}
	
	public List<Product> getProductByCategory(String category) {
		for(Product product : products) {
			if(product.getCategory().equals(category) ) {
				return products;
			}
		}
		return products;
	}
	
	public Product saveProduct(Product product) {
		if(product.getId() == 0) {
			product.setId(++productCount);
		}else {
			products.remove(product);
		}
		products.add(product);
		return product;
	}
	
	public Product delete(int id) {
		for(Product product : products) {
			if(product.getId() == id) {
				Product deletedProduct = product;
				products.remove(product);
				return deletedProduct;
			}
		}
		return null;
	}
	
}
