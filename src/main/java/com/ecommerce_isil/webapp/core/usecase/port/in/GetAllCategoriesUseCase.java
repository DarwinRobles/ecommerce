package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.response.CategoryResponse;

import java.util.List;

public interface GetAllCategoriesUseCase {
    List<CategoryResponse> getAllCategories();
}
