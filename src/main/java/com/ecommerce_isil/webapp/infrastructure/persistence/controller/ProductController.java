package com.ecommerce_isil.webapp.infrastructure.persistence.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetProductCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final GetProductCase getProductCase;

    public ProductController(GetProductCase getProductCase) {
        this.getProductCase = getProductCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable UUID id) {
        ProductResponse response = getProductCase.getProduct(id);
        return ResponseEntity.ok(response);
import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateProductCase;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CreateProductCase createProductCase;

    public ProductController(CreateProductCase createProductCase){
        this.createProductCase = createProductCase;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> registerProduct (@RequestBody CreateProductRequest request){
        ResponseEntity<ProductResponse> response = ResponseEntity.ok(createProductCase.createProduct(request));
        return response;
    }
}
