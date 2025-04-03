package com.example.rest_api.entity;

import com.example.rest_api.validation.ValidProductCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "Product title is required")
    @Column(name = "title")
    String title;

    @NotEmpty(message = "Product category is required")
    @ValidProductCategory
    String category;

    @PositiveOrZero(message = "Invalid product price")
    Double price;

    // Entity class should have default constructor, getter/setter methods for all fields

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
