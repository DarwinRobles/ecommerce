package com.ecommerce_isil.webapp.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
    private String name;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;

    public UpdateUserRequest(
            String name,
            String lastName,
            String firstName,
            String email,
            String password,
            String phone
    ) {
        this.name = name;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
    }
}
