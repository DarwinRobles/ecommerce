package com.ecommerce_isil.webapp.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSalesOrderRequest {

    private int status;
    private int quantity;

    public UpdateSalesOrderRequest() {
    }
}