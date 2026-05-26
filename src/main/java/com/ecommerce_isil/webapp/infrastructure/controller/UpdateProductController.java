package com.ecommerce_isil.webapp.infrastructure.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateClientRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.UpdateProductCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class UpdateProductController {
    private final UpdateProductCase updateProductCase;

    public UpdateProductController(UpdateProductCase updateProductCase){
        this.updateProductCase = updateProductCase;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable UUID id, @RequestBody CreateProductRequest request){
        ProductResponse response = updateProductCase.updateProduct(id, request);
        return ResponseEntity.ok(response);
    }

}
