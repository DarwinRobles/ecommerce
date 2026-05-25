package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;

import java.util.UUID;

public interface GetProductCase {
    ProductResponse getProduct(UUID id);
}
