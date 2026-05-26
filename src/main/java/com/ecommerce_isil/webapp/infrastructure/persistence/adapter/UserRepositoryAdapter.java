package com.ecommerce_isil.webapp.infrastructure.persistence.adapter;

import com.ecommerce_isil.webapp.core.entity.User;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import com.ecommerce_isil.webapp.infrastructure.persistence.entity.UserJpaEntity;
import com.ecommerce_isil.webapp.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;

    public UserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        UserJpaEntity entity = toEntity(user);
        UserJpaEntity saved = userRepository.save(entity);
        return toDomain(saved);
    }



    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id).map(this::toDomain);
    }

    //eliminar User por ID
    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    //filtrar segun el año, en la parte de UserService establecemos como se trabaja esta lógica
    @Override
    public List<User> findByCreatedAtBetween(LocalDateTime begin, LocalDateTime end) {
        List<UserJpaEntity> entities = userRepository.findByCreatedAtBetween(begin, end);
        return entities.stream().map(this::toDomain).toList();
    }

    private UserJpaEntity toEntity(User user) {
        UserJpaEntity entity = new UserJpaEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole());
        entity.setPhone(user.getPhone());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }

    private User toDomain(UserJpaEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setRole(entity.getRole());
        user.setPhone(entity.getPhone());
        user.setCreatedAt(entity.getCreatedAt());
        user.setUpdatedAt(entity.getUpdatedAt());
        return user;
    }
}
