package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.response.LogoutUserResponse;

public interface LogoutUserCase {
    LogoutUserResponse logoutUser(String email);
}
