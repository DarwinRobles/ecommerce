package com.ecommerce_isil.webapp.infrastructure.persistence.jpa;

import com.ecommerce_isil.webapp.infrastructure.persistence.entity.ProductJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductJpaEntity, UUID> {

    List<ProductJpaEntity> findTop5ByOrderBySalesDesc();

}
    List<ProductJpaEntity> findByPriceBetween (BigDecimal minPrice, BigDecimal maxPrice);
}
