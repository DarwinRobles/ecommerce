package com.ecommerce_isil.webapp.infrastructure.persistence.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateClientRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ClientResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateClientCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final CreateClientCase createClientCase;

    public ClientController(CreateClientCase createClientCase) {
        this.createClientCase = createClientCase;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody CreateClientRequest request) {
        ClientResponse response = createClientCase.createClient(request);
        return ResponseEntity.ok(response);
    }
}