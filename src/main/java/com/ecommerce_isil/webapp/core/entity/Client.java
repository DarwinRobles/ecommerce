package com.ecommerce_isil.webapp.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Client {
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

    public Client() {
    }
}
