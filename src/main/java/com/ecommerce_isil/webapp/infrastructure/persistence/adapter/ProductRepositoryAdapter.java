package com.ecommerce_isil.webapp.infrastructure.persistence.adapter;

import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.port.out.ProductRepositoryPort;
import com.ecommerce_isil.webapp.infrastructure.persistence.entity.ProductJpaEntity;
import com.ecommerce_isil.webapp.infrastructure.persistence.jpa.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;
@Component

@Repository
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductRepository productRepository;

    public ProductRepositoryAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //update
    @Override
    public Product updateProduct(Product product){
        ProductJpaEntity entity = toEntity(product);
        ProductJpaEntity updated = productRepository.save(entity);
        return toDomain(updated);
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
    public List<Product> findTopSellingProducts() {
        return productRepository.findTop5ByOrderBySalesDesc()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
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
        entity.setImageUrl(product.getImageUrl());
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
        product.setImageUrl(entity.getImageUrl());
        return product;
    }

    @Override
    public List<Product> findByPriceRange (BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice)
                .stream()
                .map(jpaEntity -> {
                    Product product = new Product();
                    product.setId(jpaEntity.getId());
                    product.setName(jpaEntity.getName());
                    product.setDescription(jpaEntity.getDescription());
                    product.setPrice(jpaEntity.getPrice());
                    product.setStock(jpaEntity.getStock());
                    product.setSales(jpaEntity.getSales());
                    product.setIdCategory(jpaEntity.getIdCategory());
                    product.setCreatedAt(jpaEntity.getCreatedAt());
                    product.setUpdatedAt(jpaEntity.getUpdatedAt());
                    product.setStatus(jpaEntity.isStatus());
                    return product;
                }).toList();
    }
}
