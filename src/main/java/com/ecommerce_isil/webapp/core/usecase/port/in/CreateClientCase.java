package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateClientRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ClientResponse;

import java.util.UUID;

public interface CreateClientCase {
    ClientResponse createClient(CreateClientRequest request);
    ClientResponse getClient(UUID id);
}
