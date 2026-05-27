package com.ecommerce_isil.webapp.infrastructure.controller;

import com.ecommerce_isil.webapp.core.usecase.port.in.DeleteUserCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class DeleteUserController {
    private final DeleteUserCase deleteUserCase;

    public DeleteUserController(DeleteUserCase deleteUserCase){
        this.deleteUserCase = deleteUserCase;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        deleteUserCase.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
