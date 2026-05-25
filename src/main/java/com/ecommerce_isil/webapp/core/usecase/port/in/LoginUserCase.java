package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.LoginUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.LoginUserResponse;

import java.util.Optional;

public interface LoginUserCase {
    Optional<LoginUserResponse> login(LoginUserRequest request);
}
