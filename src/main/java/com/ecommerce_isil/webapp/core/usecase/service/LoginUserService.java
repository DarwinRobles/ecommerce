package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.usecase.dto.request.LoginUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.LoginUserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.LoginUserCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserService implements LoginUserCase {
    private final UserRepositoryPort userRepositoryPort;

    public LoginUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<LoginUserResponse> login(LoginUserRequest request) {
        if (request.getEmail() == null || request.getPassword() == null) {
            return Optional.empty();
        }

        return userRepositoryPort.findByEmail(request.getEmail())
                .filter(user -> request.getPassword().equals(user.getPassword()))
                .map(user -> new LoginUserResponse(
                        user.getId(),
                        user.getName(),
                        user.getLastName(),
                        user.getFirstName(),
                        user.getEmail(),
                        user.getRole(),
                        "Login exitoso"
                ));
    }
}
