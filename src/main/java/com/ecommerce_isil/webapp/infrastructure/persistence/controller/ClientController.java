package com.ecommerce_isil.webapp.infrastructure.persistence.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.response.ClientResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetClientListCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final GetClientListCase getClientListCase;

    public ClientController(GetClientListCase getClientListCase){
        this.getClientListCase = getClientListCase;
    }

    @GetMapping

    public ResponseEntity<Page<ClientResponse>> getClients(Pageable pageable) {
        Page<ClientResponse> response  =  getClientListCase.getClients(pageable);
        return ResponseEntity.ok(response);
    }
}
