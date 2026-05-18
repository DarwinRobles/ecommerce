package com.ecommerce_isil.webapp.core.usecase.port.out;

import com.ecommerce_isil.webapp.core.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepositoryPort {
    Category save(Category category);
    List<Category> findAll();
    void deleteById(UUID id);

    Optional<Category> findById(UUID id);
}