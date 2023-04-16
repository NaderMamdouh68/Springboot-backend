package com.example.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Products;
import com.example.backend.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductsService productsService;

    public ProductController(ProductsService productsService) {
        super();
        this.productsService = productsService;
    }


    @PostMapping
    public ResponseEntity<Products>saveproduct(@RequestBody Products products) {
        return new ResponseEntity<Products>(productsService.saveproduct(products),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }


    @GetMapping("productdetails/{id}")
    public ResponseEntity<Products> getproductById(@PathVariable("id") Long productId) {
        return new ResponseEntity<Products>(productsService.getproductById(productId),HttpStatus.OK);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<Products> updateproductById(@RequestBody Products product, @PathVariable("id") Long productId) {
        return new ResponseEntity<Products>(productsService.updateproductById(product, productId),HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteproductById(@PathVariable("id") Long productId) {
        productsService.deleteproductById(productId );
        return new ResponseEntity<String>("Product deleted successfully",HttpStatus.OK);
    }

}
