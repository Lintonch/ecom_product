package com.ecom.productService.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dto.ProductRequestDTO;
import com.ecom.entity.Product;
import com.ecom.exception.ProductNotFoundException;
import com.ecom.repository.ProductRepository;
import com.ecom.service.ProductService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;

    @Override
    public Product addProduct(ProductRequestDTO dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .brand(dto.getBrand())
                .category(dto.getCategory())
                .color(dto.getColor())
                .size(dto.getSize())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .description(dto.getDescription())
                .imageUrls(dto.getImageUrls())
                .rating(0.0)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
    
    @Override
    @Transactional
    public Product updateProduct(Long id, ProductRequestDTO dto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        existingProduct.setName(dto.getName());
        existingProduct.setBrand(dto.getBrand());
        existingProduct.setCategory(dto.getCategory());
        existingProduct.setColor(dto.getColor());
        existingProduct.setSize(dto.getSize());
        existingProduct.setPrice(dto.getPrice());
        existingProduct.setStock(dto.getStock());
        existingProduct.setDescription(dto.getDescription());
        existingProduct.setImageUrls(dto.getImageUrls());
        existingProduct.setUpdatedAt(new Date());

        return productRepository.save(existingProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
        productRepository.delete(product);
}
}
