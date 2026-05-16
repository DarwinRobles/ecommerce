package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.Category;
import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterCategoryRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.CategoryResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.RegisterCategoryUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.CategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryService implements RegisterCategoryUseCase {

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
}