package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface FilterProductByCategoryUseCase {
    Page<ProductResponse> filterByCategory(UUID idCategory, Pageable pageable);
}