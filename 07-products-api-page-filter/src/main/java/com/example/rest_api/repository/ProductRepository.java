package com.example.rest_api.repository;

import com.example.rest_api.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Filter by title containing a keyword
    Page<Product> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
