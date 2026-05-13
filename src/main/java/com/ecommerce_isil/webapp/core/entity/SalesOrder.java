package com.ecommerce_isil.webapp.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SalesOrder {
    private UUID id;
    private LocalDateTime createdAt;
    private UUID idClient;
    private UUID idProduct;
    private int status;
    private int quantity;

    public SalesOrder() {
    }
}
