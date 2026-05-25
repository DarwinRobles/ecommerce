package com.ecommerce_isil.webapp.core.usecase.port.out;

import com.ecommerce_isil.webapp.core.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Product save(Product product);

    Optional<Product> findById(UUID id);
    void deleteById(UUID id);
    List<Product> findByStatus(boolean status);

    Product updateProduct(Product product);
    List<Product> findByPriceRange (BigDecimal minPrice, BigDecimal maxPrice);
}
