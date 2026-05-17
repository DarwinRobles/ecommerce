package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.UpdateSalesOrderRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.SalesOrderResponse;

import java.util.UUID;

public interface UpdateSalesOrderCase {

    SalesOrderResponse updateSalesOrder(UUID id, UpdateSalesOrderRequest request);
}
