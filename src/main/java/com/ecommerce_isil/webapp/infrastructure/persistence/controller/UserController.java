package com.ecommerce_isil.webapp.infrastructure.persistence.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.RegisterUserCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RegisterUserCase registerUserCase;

    public UserController(RegisterUserCase registerUserCase) {
        this.registerUserCase = registerUserCase;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody RegisterUserRequest request) {
        return registerUserCase.registerUser(request);
    }
}