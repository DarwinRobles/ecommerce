package com.ecommerce_isil.webapp.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SalesOrderResponse {
    private UUID id;
    private LocalDateTime createdAt;
    private UUID idClient;
    private UUID idProduct;
    private int status;
    private int quantity;

    public SalesOrderResponse(
            UUID id,
            LocalDateTime createdAt,
            UUID idClient,
            UUID idProduct,
            int status,
            int quantity
    ) {
        this.id = id;
        this.createdAt = createdAt;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.status = status;
        this.quantity = quantity;
    }
}
