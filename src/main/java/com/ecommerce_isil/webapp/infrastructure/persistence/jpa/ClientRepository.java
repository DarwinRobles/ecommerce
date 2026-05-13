package com.ecommerce_isil.webapp.infrastructure.persistence.jpa;

import com.ecommerce_isil.webapp.infrastructure.persistence.entity.ClientJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientJpaEntity, UUID> {
}
