package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UploadProductImageResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateProductCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.UploadProductImageCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.ProductRepositoryPort;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetProductCase;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProductService implements CreateProductCase, GetProductCase {
public class ProductService implements CreateProductCase, UploadProductImageCase {

@Service
public class ProductService implements CreateProductCase {
    private final ProductRepositoryPort productRepositoryPort;
    private final String uploadDir;

    public ProductService(ProductRepositoryPort productRepositoryPort,
                          @Value("${app.upload.dir:uploads}") String uploadDir) throws IOException {
        this.productRepositoryPort = productRepositoryPort;
        this.uploadDir = uploadDir;
        Files.createDirectories(Paths.get(uploadDir));
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
    public ProductResponse getProduct(UUID id) {
        Product product = productRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return toResponse(product);
    }

    private ProductResponse toResponse(Product product) {
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

    @Override
    public UploadProductImageResponse uploadImage(UUID productId, byte[] imageBytes, String filename) throws IOException {
        Product product = productRepositoryPort.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + productId));

        String ext = filename.substring(filename.lastIndexOf('.'));
        String storedName = UUID.randomUUID() + ext;
        Files.write(Paths.get(uploadDir).resolve(storedName), imageBytes);

        product.setImageUrl("/uploads/" + storedName);
        product.setUpdatedAt(LocalDateTime.now());
        productRepositoryPort.save(product);

        return new UploadProductImageResponse(productId, product.getImageUrl());
    }
}
