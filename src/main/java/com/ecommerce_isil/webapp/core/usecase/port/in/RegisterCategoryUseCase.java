package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterCategoryRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.CategoryResponse;

public interface RegisterCategoryUseCase {
    CategoryResponse registerCategory(RegisterCategoryRequest request);
}