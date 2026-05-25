package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;

import java.util.List;

public interface FilterProductByStatusCase {
    List<ProductResponse> filterByStatus(boolean status);
}
