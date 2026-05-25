package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.UpdateUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;

import java.util.UUID;

public interface UpdateUserCase {
    UserResponse updateUser(UUID id, UpdateUserRequest request);
}
