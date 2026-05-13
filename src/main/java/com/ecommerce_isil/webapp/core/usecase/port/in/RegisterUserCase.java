package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;

public interface RegisterUserCase {
    UserResponse registerUser(RegisterUserRequest request);
}
