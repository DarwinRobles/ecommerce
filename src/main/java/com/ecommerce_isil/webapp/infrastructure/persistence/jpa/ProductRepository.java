package com.ecommerce_isil.webapp.infrastructure.persistence.jpa;

import com.ecommerce_isil.webapp.infrastructure.persistence.entity.ProductJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductJpaEntity, UUID> {
    Page<ProductJpaEntity> findByIdCategory(UUID idCategory, Pageable pageable);
}