package com.ecommerce_isil.webapp.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ProductResponse {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private BigDecimal sales;
    private UUID idCategory;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean status;

    public ProductResponse(
            UUID id,
            String name,
            String description,
            BigDecimal price,
            int stock,
            BigDecimal sales,
            UUID idCategory,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            boolean status
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.idCategory = idCategory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }
}
