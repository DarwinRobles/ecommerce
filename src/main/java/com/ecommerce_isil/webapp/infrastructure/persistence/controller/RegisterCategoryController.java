package com.ecommerce_isil.webapp.infrastructure.persistence.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterCategoryRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.CategoryResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.RegisterCategoryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class RegisterCategoryController {

    private final RegisterCategoryUseCase registerCategoryCase;

    public RegisterCategoryController(RegisterCategoryUseCase registerCategoryCase) {
        this.registerCategoryCase = registerCategoryCase;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> registerCategory(@RequestBody RegisterCategoryRequest request) {
        CategoryResponse response = registerCategoryCase.registerCategory(request);
        return ResponseEntity.ok(response);
    }
}