package com.ecommerce_isil.webapp.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LoginUserResponse {
    private UUID id;
    private String name;
    private String lastName;
    private String firstName;
    private String email;
    private String role;
    private String message;

    public LoginUserResponse(
            UUID id,
            String name,
            String lastName,
            String firstName,
            String email,
            String role,
            String message
    ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.role = role;
        this.message = message;
    }
}
