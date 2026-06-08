package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.RegisterUserCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import com.ecommerce_isil.webapp.core.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements RegisterUserCase {
    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserResponse registerUser(RegisterUserRequest request) {
        // 1. Armamos el objeto puro de negocio
        User user = new User();

        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());

        // Reglas de negocio:
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setRole("USER");

        // 2. Mandamos a guardar usando el contrato
        User savedUser = userRepositoryPort.save(user);

        // 3. Devolvemos la respuesta
        return new UserResponse (
               savedUser.getId(),
               savedUser.getName(),
               savedUser.getLastName(),
               savedUser.getFirstName(),
               savedUser.getEmail(),
               savedUser.getPhone(),
               savedUser.getCreatedAt(),
               savedUser.getUpdatedAt(),
               savedUser.getRole()
        );

    }
}
