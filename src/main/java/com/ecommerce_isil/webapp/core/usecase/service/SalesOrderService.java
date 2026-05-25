package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.SalesOrder;
import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateSalesOrderRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.request.UpdateSalesOrderRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.SalesOrderResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.CreateSalesOrderCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.UpdateSalesOrderCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.DeleteSalesOrderCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.SalesOrderRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

public class SalesOrderService implements CreateSalesOrderCase, UpdateSalesOrderCase {

@Service
public class SalesOrderService implements CreateSalesOrderCase {
    private final SalesOrderRepositoryPort salesOrderRepositoryPort;


import java.time.LocalDateTime;
import java.util.UUID;

public class SalesOrderService implements CreateSalesOrderCase, DeleteSalesOrderCase {    private final SalesOrderRepositoryPort salesOrderRepositoryPort;

    public SalesOrderService(SalesOrderRepositoryPort salesOrderRepositoryPort) {
        this.salesOrderRepositoryPort = salesOrderRepositoryPort;
    }

    @Override
    public void deleteSalesOrder(UUID idSalesOrder) {
        salesOrderRepositoryPort.deleteById(idSalesOrder);
    }
    public SalesOrderResponse createSalesOrder(CreateSalesOrderRequest request) {

        SalesOrder order = new SalesOrder();

        order.setIdClient(request.getIdClient());
        order.setIdProduct(request.getIdProduct());
        order.setStatus(request.getStatus());
        order.setQuantity(request.getQuantity());
        order.setCreatedAt(LocalDateTime.now());

        SalesOrder saved = salesOrderRepositoryPort.save(order);

        return new SalesOrderResponse(
                saved.getId(),
                saved.getCreatedAt(),
                saved.getIdClient(),
                saved.getIdProduct(),
                saved.getStatus(),
                saved.getQuantity()
        );
    }

    @Override
    public SalesOrderResponse updateSalesOrder(UUID id, UpdateSalesOrderRequest request) {

        SalesOrder order = salesOrderRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(request.getStatus());
        order.setQuantity(request.getQuantity());

        SalesOrder updated = salesOrderRepositoryPort.update(order);

        return new SalesOrderResponse(
                updated.getId(),
                updated.getCreatedAt(),
                updated.getIdClient(),
                updated.getIdProduct(),
                updated.getStatus(),
                updated.getQuantity()
        );
    }
}