package com.ecommerce_isil.webapp.infrastructure.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetListUserCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class GetListUserController {
    private final GetListUserCase getListUserCase;

    public GetListUserController(GetListUserCase getListUserCase) {
        this.getListUserCase = getListUserCase;
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getListUser(Pageable pageable) {
        Page<UserResponse> response = getListUserCase.getListUser(pageable);
        return ResponseEntity.ok(response);
    }
}
