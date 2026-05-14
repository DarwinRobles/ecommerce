package com.ecommerce_isil.webapp.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="users")
public class UserJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String role;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserJpaEntity(){}
}
