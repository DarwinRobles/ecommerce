package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateSalesOrderRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.SalesOrderResponse;

public interface CreateSalesOrderCase {
    SalesOrderResponse createSalesOrder(CreateSalesOrderRequest request);
}
