package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.Client;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateClientRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ClientResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateClientCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.GetClientListCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.ClientRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class ClientService implements CreateClientCase, GetClientListCase {
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClientService implements CreateClientCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public ClientService(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public ClientResponse createClient(CreateClientRequest request) {
        Client client = new Client();
        client.setName(request.getName());
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setAddress(request.getAddress());
        client.setDni(request.getDni());
        client.setRuc(request.getRuc());
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());

        Client saved = clientRepositoryPort.save(client);

        return new ClientResponse(
                saved.getId(),
                saved.getName(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getAddress(),
                saved.getDni(),
                saved.getRuc(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }
    @Override
    public Page<ClientResponse> getClients(Pageable pageable){
        Page<Client> clientPage = clientRepositoryPort.findAll(pageable);
        return clientPage.map(client -> new ClientResponse(
                client.getId(),
                client.getName(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhone(),
                client.getAddress(),
                client.getDni(),
                client.getRuc(),
                client.getCreatedAt(),
                client.getUpdatedAt()
        ));
    }
}
