package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;

import java.util.UUID;

public interface GetUserCase {
    UserResponse getUser(UUID id);
}
