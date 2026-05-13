package com.ecommerce_isil.webapp.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientRequest {
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String dni;
    private String ruc;

    public CreateClientRequest(
            String name,
            String firstName,
            String lastName,
            String email,
            String phone,
            String address,
            String dni,
            String ruc
    ) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dni = dni;
        this.ruc = ruc;
    }
}
