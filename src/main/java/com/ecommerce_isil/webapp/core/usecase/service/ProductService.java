package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateProductCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.FilterProductByCategoryUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.ProductRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductService implements CreateProductCase, FilterProductByCategoryUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setSales(request.getSales());
        product.setIdCategory(request.getIdCategory());
        product.setStatus(request.isStatus());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saved = productRepositoryPort.save(product);

        return new ProductResponse(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getPrice(),
                saved.getStock(),
                saved.getSales(),
                saved.getIdCategory(),
                saved.getCreatedAt(),
                saved.getUpdatedAt(),
                saved.isStatus()
        );
    }

    @Override
    public Page<ProductResponse> filterByCategory(UUID idCategory, Pageable pageable) {
        return productRepositoryPort.filterByCategory(idCategory, pageable)
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getStock(),
                        product.getSales(),
                        product.getIdCategory(),
                        product.getCreatedAt(),
                        product.getUpdatedAt(),
                        product.isStatus()
                ));
    }
}