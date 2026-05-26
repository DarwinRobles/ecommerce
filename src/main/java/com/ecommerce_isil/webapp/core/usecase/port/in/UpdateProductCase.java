package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;

import java.util.UUID;

public interface UpdateProductCase {
    ProductResponse updateProduct(UUID id, CreateProductRequest request);
}
