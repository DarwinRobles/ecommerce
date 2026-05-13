package com.ecommerce_isil.webapp.infrastructure.persistence.jpa;

import com.ecommerce_isil.webapp.infrastructure.persistence.entity.SalesOrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesOrderRepository extends JpaRepository<SalesOrderJpaEntity, UUID> {
}
