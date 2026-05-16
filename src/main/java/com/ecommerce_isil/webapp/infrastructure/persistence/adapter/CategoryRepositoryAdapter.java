package com.ecommerce_isil.webapp.infrastructure.persistence.adapter;

import com.ecommerce_isil.webapp.core.entity.Category;
import com.ecommerce_isil.webapp.core.usecase.port.out.CategoryRepositoryPort;
import com.ecommerce_isil.webapp.infrastructure.persistence.entity.CategoryJpaEntity;
import com.ecommerce_isil.webapp.infrastructure.persistence.jpa.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {

    private final CategoryRepository categoryRepository;

    public CategoryRepositoryAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        CategoryJpaEntity entity = toEntity(category);
        CategoryJpaEntity saved = categoryRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return categoryRepository.findById(id).map(this::toDomain);
    }

    private CategoryJpaEntity toEntity(Category category) {
        CategoryJpaEntity entity = new CategoryJpaEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        entity.setStatus(category.isStatus());
        entity.setCreatedAt(category.getCreatedAt());
        entity.setUpdatedAt(category.getUpdatedAt());
        return entity;
    }

    private Category toDomain(CategoryJpaEntity entity) {
        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getName());
        category.setDescription(entity.getDescription());
        category.setStatus(entity.isStatus());
        category.setCreatedAt(entity.getCreatedAt());
        category.setUpdatedAt(entity.getUpdatedAt());
        return category;
    }
}