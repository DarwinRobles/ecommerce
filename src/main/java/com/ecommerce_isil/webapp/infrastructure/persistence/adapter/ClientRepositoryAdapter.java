package com.ecommerce_isil.webapp.infrastructure.persistence.adapter;

import com.ecommerce_isil.webapp.core.entity.Client;
import com.ecommerce_isil.webapp.core.usecase.port.out.ClientRepositoryPort;
import com.ecommerce_isil.webapp.infrastructure.persistence.entity.ClientJpaEntity;
import com.ecommerce_isil.webapp.infrastructure.persistence.jpa.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {
    private final ClientRepository clientRepository;

    public ClientRepositoryAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Page<Client> findAll(Pageable pageable){
        return clientRepository.findAll(pageable).map(this::toDomain);
    }


    @Override
    public Client save(Client client) {
        ClientJpaEntity entity = toEntity(client);
        ClientJpaEntity saved = clientRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id).map(this::toDomain);
    }

    private ClientJpaEntity toEntity(Client client) {
        ClientJpaEntity entity = new ClientJpaEntity();
        entity.setId(client.getId());
        entity.setName(client.getName());
        entity.setFirstName(client.getFirstName());
        entity.setLastName(client.getLastName());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
        entity.setAddress(client.getAddress());
        entity.setDni(client.getDni());
        entity.setRuc(client.getRuc());
        entity.setCreatedAt(client.getCreatedAt());
        entity.setUpdatedAt(client.getUpdatedAt());
        return entity;
    }

    private Client toDomain(ClientJpaEntity entity) {
        Client client = new Client();
        client.setId(entity.getId());
        client.setName(entity.getName());
        client.setFirstName(entity.getFirstName());
        client.setLastName(entity.getLastName());
        client.setEmail(entity.getEmail());
        client.setPhone(entity.getPhone());
        client.setAddress(entity.getAddress());
        client.setDni(entity.getDni());
        client.setRuc(entity.getRuc());
        client.setCreatedAt(entity.getCreatedAt());
        client.setUpdatedAt(entity.getUpdatedAt());
        return client;
    }
}
