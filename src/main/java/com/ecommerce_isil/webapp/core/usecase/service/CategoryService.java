package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.Category;
import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterCategoryRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.request.UpdateCategoryRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.CategoryResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.DeleteCategoryUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetAllCategoriesUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.RegisterCategoryUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.UpdateCategoryUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.CategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService implements
        RegisterCategoryUseCase,
        GetAllCategoriesUseCase,
        DeleteCategoryUseCase,
        UpdateCategoryUseCase
{

    private final CategoryRepositoryPort categoryRepositoryPort;

    public CategoryService(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public CategoryResponse registerCategory(RegisterCategoryRequest request) {

        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        category.setStatus(true);
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());

        Category saved = categoryRepositoryPort.save(category);

        return new CategoryResponse(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.isStatus(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }


    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepositoryPort.findAll()
                .stream()
                .map(category -> new CategoryResponse(
                        category.getId(),
                        category.getName(),
                        category.getDescription(),
                        category.isStatus(),
                        category.getCreatedAt(),
                        category.getUpdatedAt()
                ))
                .toList();
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepositoryPort.findById(id).orElseThrow();
        categoryRepositoryPort.deleteById(id);
    }

    @Override
    public CategoryResponse updateCategory(UUID id, UpdateCategoryRequest request) {
        Category categoryToUpdate = categoryRepositoryPort
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        categoryToUpdate.setName(request.getName());
        categoryToUpdate.setDescription(request.getDescription());
        categoryToUpdate.setUpdatedAt(LocalDateTime.now());

        Category updatedCategory = categoryRepositoryPort.save(categoryToUpdate);

        return new CategoryResponse(
                updatedCategory.getId(),
                updatedCategory.getName(),
                updatedCategory.getDescription(),
                updatedCategory.isStatus(),
                updatedCategory.getCreatedAt(),
                updatedCategory.getUpdatedAt()
        );
    }
}