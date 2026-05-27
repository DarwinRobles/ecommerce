package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetUserCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import com.ecommerce_isil.webapp.core.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service

public class UserService implements GetUserCase {
    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserResponse getUser(UUID id) {
        User existingUser = userRepositoryPort.findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponse(
                existingUser.getId(),
                existingUser.getName(),
                existingUser.getLastName(),
                existingUser.getFirstName(),
                existingUser.getEmail(),
                existingUser.getPhone(),
                existingUser.getCreatedAt(),
                existingUser.getUpdatedAt(),
                existingUser.getRole()
        );
    }
}