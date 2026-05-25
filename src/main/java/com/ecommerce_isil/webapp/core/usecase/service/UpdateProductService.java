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
    public ProductResponse updateProduct(UUID id, CreateProductRequest request){
        Product existingProduct = productRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        if(existingProduct.getName() != null){
            existingProduct.setName(request.getName());
        }
        if(existingProduct.getDescription() != null){
            existingProduct.setDescription((request.getDescription()));
        }

        Product productUpdated = productRepositoryPort.updateProduct(existingProduct);
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.stock = stock;
//        this.sales = sales;
//        this.idCategory = idCategory;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.status = status;
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
