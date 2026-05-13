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
@Table(name = "clients")
public class ClientJpaEntity {

    @Id
    @GeneratedValue
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

    public ClientJpaEntity() {
    }
}
