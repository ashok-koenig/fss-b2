package com.example.rest_api.service;

import com.example.rest_api.entity.Product;
import com.example.rest_api.repository.ProductRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    // Common service method for create and update
    @Transactional
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Page<Product> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Page<Product> filterProducts(String title, Pageable pageable){
        return productRepository.findByTitleContainingIgnoreCase(title, pageable);
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    @Transactional
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

}
