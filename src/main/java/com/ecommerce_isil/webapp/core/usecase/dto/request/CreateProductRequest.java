package com.ecommerce_isil.webapp.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter

public class CreateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private BigDecimal sales;
    private UUID idCategory;
    private boolean status;

    public CreateProductRequest(
            String name,
            String description,
            BigDecimal price,
            int stock,
            BigDecimal sales,
            UUID idCategory,
            boolean status
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.idCategory = idCategory;
        this.status = status;
    }
}
