package com.ecommerce_isil.webapp.infrastructure.persistence.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateClientRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ClientResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateClientCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class RegisterClientController {

    private final CreateClientCase createClientCase;

    public RegisterClientController(CreateClientCase createClientCase){
        this.createClientCase = createClientCase;
    }

    @PostMapping
    public ClientResponse registerClient(@RequestBody CreateClientRequest clientRequest){
        return createClientCase.createClient(clientRequest);
    }

}

