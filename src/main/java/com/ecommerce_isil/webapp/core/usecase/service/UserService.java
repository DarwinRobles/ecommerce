package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.RegisterUserCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import com.ecommerce_isil.webapp.core.entity.User;

import java.time.LocalDateTime;

public class UserService implements RegisterUserCase {
    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserResponse registerUser(RegisterUserRequest request) {
        User user = new User();

        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setRole("USER");

        User savedUser = userRepositoryPort.save(user);

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
