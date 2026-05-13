package com.ecommerce_isil.webapp.core.usecase.port.out;

import com.ecommerce_isil.webapp.core.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Product save(Product product);

    Optional<Product> findById(UUID id);

    Page<Product> filterByCategory(UUID idCategory, Pageable pageable);
}