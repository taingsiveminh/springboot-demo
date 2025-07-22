package com.minh.demo.controller;

import com.minh.demo.model.BaseResponseModel;
import com.minh.demo.model.BaseResponseWithDataModel;
import com.minh.demo.model.ProductModel;
import com.minh.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<BaseResponseWithDataModel> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseWithDataModel> getProduct(@PathVariable("id") Long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponseWithDataModel> searchProductsByFilters(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice
    ) {
        return productService.searchProducts(name,minPrice,maxPrice);
    }

    @PostMapping
    public ResponseEntity<BaseResponseModel> createProduct(@RequestBody ProductModel payload) {
        return productService.createProduct(payload);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseModel> updateProduct(@PathVariable("id") Long productId,@RequestBody ProductModel payload) {
        return productService.updateProduct(productId,payload);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseModel> deleteProduct(@PathVariable("id") Long productId) {
        return productService.deleteProduct(productId);
    }
}
