package com.ecommerce_isil.webapp.infrastructure.persistence;

import com.ecommerce_isil.webapp.core.usecase.port.in.FilterProductByCategoryUseCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.ProductRepositoryPort;
import com.ecommerce_isil.webapp.core.usecase.service.ProductService;
import com.ecommerce_isil.webapp.infrastructure.persistence.adapter.ProductRepositoryAdapter;
import com.ecommerce_isil.webapp.infrastructure.persistence.jpa.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductRepositoryPort productRepositoryPort(ProductRepository productRepository) {
        return new ProductRepositoryAdapter(productRepository);
    }

    @Bean
    public FilterProductByCategoryUseCase filterProductByCategoryUseCase(ProductRepositoryPort productRepositoryPort) {
        return new ProductService(productRepositoryPort);
    }
}