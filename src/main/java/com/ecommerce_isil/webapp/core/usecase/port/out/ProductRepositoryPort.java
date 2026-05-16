package com.ecommerce_isil.webapp.core.usecase.port.out;

import com.ecommerce_isil.webapp.core.entity.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Product save(Product product);

    Optional<Product> findById(UUID id);

    Product updateProduct(Product product);
}
