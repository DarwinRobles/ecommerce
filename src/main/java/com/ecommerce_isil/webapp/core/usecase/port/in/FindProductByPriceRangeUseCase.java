package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface FindProductByPriceRangeUseCase {

    List<Product> execute (BigDecimal minPrice, BigDecimal maxPrice);
}
