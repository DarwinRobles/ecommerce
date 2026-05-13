package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateProductRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;

public interface CreateProductCase {
    ProductResponse createProduct(CreateProductRequest request);
}
