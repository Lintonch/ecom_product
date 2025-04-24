package com.ecom.service;

import java.util.List;

import com.ecom.dto.ProductRequestDTO;
import com.ecom.entity.Product;

public interface ProductService {

	Product addProduct(ProductRequestDTO dto);

	Product getProductById(Long id);

	List<Product> getAllProducts();

	List<Product> getProductsByBrand(String brand);

	List<Product> getProductsByCategory(String category);

	List<Product> searchProducts(String keyword);
	
	Product updateProduct(Long id, ProductRequestDTO dto);
	void deleteProduct(Long id);


}
