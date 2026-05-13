package com.ecommerce_isil.webapp.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID id;
    private String name;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String role;
    private int phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(){}

}
