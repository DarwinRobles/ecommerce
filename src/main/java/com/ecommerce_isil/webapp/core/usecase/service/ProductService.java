package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateProductCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.DeleteProductCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.FilterProductByStatusCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.ProductRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductService implements CreateProductCase, DeleteProductCase, FilterProductByStatusCase {
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

        return toResponse(saved);
    }

    @Override
    public void deleteProduct(UUID id){
        productRepositoryPort.deleteById(id);
    }

    @Override
    public List<ProductResponse> filterByStatus(boolean status){
        return productRepositoryPort.findByStatus(status)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private ProductResponse toResponse(Product product){
        return new ProductResponse(
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
        );
    }
}
