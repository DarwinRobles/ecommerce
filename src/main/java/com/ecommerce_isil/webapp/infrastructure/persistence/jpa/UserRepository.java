package com.ecommerce_isil.webapp.infrastructure.persistence.jpa;

import com.ecommerce_isil.webapp.infrastructure.persistence.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<UserJpaEntity, UUID> {
}
