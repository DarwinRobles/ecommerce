package com.ecommerce_isil.webapp.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ClientResponse {
    private UUID id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String dni;
    private String ruc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClientResponse(
            UUID id,
            String name,
            String firstName,
            String lastName,
            String email,
            String phone,
            String address,
            String dni,
            String ruc,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dni = dni;
        this.ruc = ruc;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
