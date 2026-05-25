package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UploadProductImageResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateProductCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.UploadProductImageCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
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
    public List<Product> getTopSellingProducts() {
    return productRepositoryPort.findTopSellingProducts();
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
