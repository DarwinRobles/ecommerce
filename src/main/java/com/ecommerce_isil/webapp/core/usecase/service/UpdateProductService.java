package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.UpdateProductCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateProductService implements UpdateProductCase {
    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductService(ProductRepositoryPort productRepositoryPort){
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public ProductResponse updateProduct(UUID id, CreateProductRequest request) {
        Product existingProduct = productRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Product no found"));

        if(existingProduct.getName() != null){
            existingProduct.setName(request.getDescription());
        }

        Product productUpdated = productRepositoryPort.updateProduct(existingProduct);

        return new ProductResponse(
                productUpdated.getId(),
                productUpdated.getName(),
                productUpdated.getDescription(),
                productUpdated.getPrice(),
                productUpdated.getStock(),
                productUpdated.getSales(),
                productUpdated.getIdCategory(),
                productUpdated.getCreatedAt(),
                productUpdated.getUpdatedAt(),
                productUpdated.isStatus()
        );
    }
}
