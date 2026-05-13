package com.ecommerce_isil.webapp.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UserResponse {
    private UUID id;
    private String name;
    private String lastName;
    private String firstName;
    private String email;
    private int phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String role;

    public UserResponse(
            UUID id,
            String name,
            String lastName,
            String firstName,
            String email,
            int phone,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            String role
    ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

}
