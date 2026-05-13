package com.ecommerce_isil.webapp.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    private String name;
    private String lastName;
    private String firstName;
    private String email;
    private String  password;
    private int phone;

    public RegisterUserRequest(
            String name,
            String lastName,
            String firstName,
            String email,
            String password,
            int phone
    ) {
        this.name = name;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

}
