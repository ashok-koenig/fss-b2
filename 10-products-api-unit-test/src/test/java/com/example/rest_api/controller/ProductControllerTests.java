package com.example.rest_api.controller;

import com.example.rest_api.entity.Product;
import com.example.rest_api.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class ProductControllerTests {
    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testGetAllProducts() throws Exception {
        List<Product> mockProducts = Arrays.asList(
                new Product(1L, "iPhone 15", "Smartphone", 15678.0),
                new Product(1L, "iPhone 16", "Smartphone", 16678.0)
        );
        when(productService.getAllProducts()).thenReturn(mockProducts);
        mockMvc.perform(get("/api/v1/products")).andExpect(status().isOk()).andExpect(jsonPath("$.size()").value(2));
    }
}
