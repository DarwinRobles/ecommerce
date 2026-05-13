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
@Entity(name = "SalesOrder")
@Table(name = "orders")
public class SalesOrderJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime createdAt;
    private UUID idClient;
    private UUID idProduct;
    private int status;
    private int quantity;

    public SalesOrderJpaEntity() {
    }
}
