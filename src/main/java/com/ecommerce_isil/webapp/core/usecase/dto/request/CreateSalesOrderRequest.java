package com.ecommerce_isil.webapp.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateSalesOrderRequest {
    private UUID idClient;
    private UUID idProduct;
    private int status;
    private int quantity;

    public CreateSalesOrderRequest(UUID idClient, UUID idProduct, int status, int quantity) {
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.status = status;
        this.quantity = quantity;
    }
}
