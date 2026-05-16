package com.ecommerce_isil.webapp.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCategoryRequest {
    private String name;
    private String description;

    public RegisterCategoryRequest(
            String name,
            String description
    ) {
        this.name = name;
        this.description = description;
    }
}