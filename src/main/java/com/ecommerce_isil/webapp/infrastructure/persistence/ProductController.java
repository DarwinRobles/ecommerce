package com.ecommerce_isil.webapp.infrastructure.persistence;

import com.ecommerce_isil.webapp.core.usecase.dto.response.ProductResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.FilterProductByCategoryUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final FilterProductByCategoryUseCase filterProductByCategoryUseCase;

    public ProductController(FilterProductByCategoryUseCase filterProductByCategoryUseCase) {
        this.filterProductByCategoryUseCase = filterProductByCategoryUseCase;
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<ProductResponse>> filterByCategory(
            @RequestParam UUID idCategory,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(filterProductByCategoryUseCase.filterByCategory(idCategory, pageable));
    }
}