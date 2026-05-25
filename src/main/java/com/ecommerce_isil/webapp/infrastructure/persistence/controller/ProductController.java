package com.ecommerce_isil.webapp.infrastructure.persistence.controller;

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
