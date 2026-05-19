package com.ecommerce_isil.webapp.infrastructure.web;


import com.ecommerce_isil.webapp.core.entity.Product;
import com.ecommerce_isil.webapp.core.usecase.port.in.FindProductByPriceRangeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final FindProductByPriceRangeUseCase findProductByPriceRangeUseCase;
    @GetMapping("/filter")
    public ResponseEntity<List<Product>> findByPriceRange (
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max
            ) {
        List<Product> products = findProductByPriceRangeUseCase.execute(min, max);

        return ResponseEntity.ok(products);
    }
}
