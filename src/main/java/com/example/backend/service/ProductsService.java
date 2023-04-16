package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Products;

public interface ProductsService {
    
    Products saveproduct(Products product);
    List<Products> getAllProducts();
    Products getproductById(Long id);
    Products updateproductById(Products product, Long id);
    void deleteproductById(Long id);


}
