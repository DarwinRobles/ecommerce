package com.ecommerce_isil.webapp.infrastructure.persistence.adapter;

import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.port.out.ProductRepositoryPort;
import com.ecommerce_isil.webapp.infrastructure.persistence.entity.ProductJpaEntity;
import com.ecommerce_isil.webapp.infrastructure.persistence.jpa.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductRepository productRepository;

    public ProductRepositoryAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        ProductJpaEntity entity = toEntity(product);
        ProductJpaEntity saved = productRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Page<Product> filterByCategory(UUID idCategory, Pageable pageable) {
        return productRepository.findByIdCategory(idCategory, pageable)
                .map(this::toDomain);
    }

    private ProductJpaEntity toEntity(Product product) {
        ProductJpaEntity entity = new ProductJpaEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setStock(product.getStock());
        entity.setSales(product.getSales());
        entity.setIdCategory(product.getIdCategory());
        entity.setCreatedAt(product.getCreatedAt());
        entity.setUpdatedAt(product.getUpdatedAt());
        entity.setStatus(product.isStatus());
        return entity;
    }

    private Product toDomain(ProductJpaEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setStock(entity.getStock());
        product.setSales(entity.getSales());
        product.setIdCategory(entity.getIdCategory());
        product.setCreatedAt(entity.getCreatedAt());
        product.setUpdatedAt(entity.getUpdatedAt());
        product.setStatus(entity.isStatus());
        return product;
    }
}