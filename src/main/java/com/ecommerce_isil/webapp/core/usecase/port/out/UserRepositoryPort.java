package com.ecommerce_isil.webapp.core.usecase.port.out;

import com.ecommerce_isil.webapp.core.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(UUID id);
    //eliminar User por id
    void deleteById(UUID id);
    //filtrar por año
    List<User> findByCreatedAtBetween(LocalDateTime begin, LocalDateTime end);
}
