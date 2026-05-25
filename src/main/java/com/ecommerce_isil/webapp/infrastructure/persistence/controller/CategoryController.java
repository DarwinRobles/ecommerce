package com.ecommerce_isil.webapp.infrastructure.persistence.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterCategoryRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.request.UpdateCategoryRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.CategoryResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.DeleteCategoryUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetAllCategoriesUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.RegisterCategoryUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.UpdateCategoryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final RegisterCategoryUseCase registerCategoryCase;
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;

    public CategoryController(RegisterCategoryUseCase registerCategoryCase, GetAllCategoriesUseCase getAllCategoriesUseCase, DeleteCategoryUseCase deleteCategoryUseCase, UpdateCategoryUseCase updateCategoryUseCase) {
        this.registerCategoryCase = registerCategoryCase;
        this.getAllCategoriesUseCase = getAllCategoriesUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> registerCategory(@RequestBody RegisterCategoryRequest request) {
        return ResponseEntity.ok(registerCategoryCase.registerCategory(request));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(getAllCategoriesUseCase.getAllCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        deleteCategoryUseCase.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable UUID id,
            @RequestBody UpdateCategoryRequest request
            ){
        return ResponseEntity.ok(updateCategoryUseCase.updateCategory(id , request));

    }
}