
package com.example.backend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.backend.exception.ResourceNotFound;
import com.example.backend.model.Products;
import com.example.backend.repository.ProductsRepo;
import com.example.backend.service.ProductsService;


@Service

public class ProductsImplementation implements ProductsService {

    private ProductsRepo productRepo;

    public ProductsImplementation (ProductsRepo productRepo){
        super();
        this.productRepo = productRepo;
    }

    @Override
    public Products saveproduct(Products product) {
        return productRepo.save(product);
    }

    @Override
    public List<Products> getAllProducts() {
        
        return productRepo.findAll() ;
    }

    @Override
    public Products getproductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User", "id", id));
    }

    @Override
    public Products updateproductById(Products product, Long id) {
        Products existingProducts = productRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User", "id", id));
        existingProducts.setProduct_name(product.getProduct_name());
        existingProducts.setDescription(product.getDescription());
        existingProducts.setPrice(product.getPrice());
        existingProducts.setCategory_id(product.getCategory_id());
        productRepo.save(existingProducts);
        return existingProducts;
    }

    @Override
    public void deleteproductById(Long id) {
        productRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User", "id", id));
        productRepo.deleteById(id);
    }


}
