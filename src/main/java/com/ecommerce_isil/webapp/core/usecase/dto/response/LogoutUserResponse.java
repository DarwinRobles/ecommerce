package com.ecommerce_isil.webapp.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutUserResponse {
    private String message;
    public LogoutUserResponse(String message){
        this.message = message;
    }
}
