package com.ecommerce_isil.webapp.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;

    @Column(precision = 14, scale = 2)
    private BigDecimal price;

    private int stock;

    @Column(precision = 14, scale = 2)
    private BigDecimal sales;

    private UUID idCategory;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private boolean status;
    private String imageUrl;

    public ProductJpaEntity() {
    }
}
