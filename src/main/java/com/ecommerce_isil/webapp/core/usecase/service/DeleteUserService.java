package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.usecase.port.in.DeleteUserCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUserService implements DeleteUserCase {
    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserService(UserRepositoryPort userRepositoryPort){
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void deleteUser(UUID id){
        userRepositoryPort.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
        userRepositoryPort.deleteById(id);
    }
}
