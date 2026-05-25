package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.User;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetListUserCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class GetListUserService implements GetListUserCase {
    private final UserRepositoryPort userRepositoryPort;

    public GetListUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Page<UserResponse> getListUser(Pageable pageable){
        return userRepositoryPort.findAll(pageable)
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getLastName(),
                        user.getFirstName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getCreatedAt(),
                        user.getUpdatedAt(),
                        user.getRole()
                ));
    }
}
