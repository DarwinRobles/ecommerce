package com.ecommerce_isil.webapp.core.usecase.port.out;

import com.ecommerce_isil.webapp.core.entity.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryPort {
    Client save(Client client);

    Optional<Client> findById(UUID id);
}
