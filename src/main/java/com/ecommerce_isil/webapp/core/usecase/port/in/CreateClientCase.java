package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateClientRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ClientResponse;

public interface CreateClientCase {
    ClientResponse createClient(CreateClientRequest request);
}
