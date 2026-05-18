package com.ecommerce_isil.webapp.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Product {
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
    private String imageUrl;

    public Product() {}
}
