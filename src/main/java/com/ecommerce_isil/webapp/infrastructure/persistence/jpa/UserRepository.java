package com.ecommerce_isil.webapp.infrastructure.persistence.jpa;

import com.ecommerce_isil.webapp.infrastructure.persistence.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface UserRepository  extends JpaRepository<UserJpaEntity, UUID> {
    //filtrar entre el inicio y el fin de un año
    List<UserJpaEntity> findByCreatedAtBetween(LocalDateTime begin, LocalDateTime end);
}
