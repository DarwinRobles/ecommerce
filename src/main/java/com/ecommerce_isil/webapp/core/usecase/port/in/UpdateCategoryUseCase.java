package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.UpdateCategoryRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.CategoryResponse;

import java.util.UUID;

public interface UpdateCategoryUseCase {
    CategoryResponse updateCategory(UUID id, UpdateCategoryRequest request);
}
