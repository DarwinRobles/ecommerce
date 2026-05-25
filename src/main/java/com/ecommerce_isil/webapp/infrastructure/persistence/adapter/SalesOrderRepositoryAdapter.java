package com.ecommerce_isil.webapp.infrastructure.persistence.adapter;

import com.ecommerce_isil.webapp.core.entity.SalesOrder;
import com.ecommerce_isil.webapp.core.usecase.port.out.SalesOrderRepositoryPort;
import com.ecommerce_isil.webapp.infrastructure.persistence.entity.SalesOrderJpaEntity;
import com.ecommerce_isil.webapp.infrastructure.persistence.jpa.SalesOrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
@Component
import org.springframework.stereotype.Repository;

@Component
import java.util.Optional;
import java.util.UUID;

@Repository
public class SalesOrderRepositoryAdapter implements SalesOrderRepositoryPort {
    private final SalesOrderRepository salesOrderRepository;

    public SalesOrderRepositoryAdapter(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    @Override
    public void deleteById(UUID idSalesOrder) {
        salesOrderRepository.deleteById(idSalesOrder);
    }

    @Override
    public SalesOrder save(SalesOrder salesOrder) {
        SalesOrderJpaEntity entity = toEntity(salesOrder);
        SalesOrderJpaEntity saved = salesOrderRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<SalesOrder> findById(UUID id) {
        return salesOrderRepository.findById(id).map(this::toDomain);
    }

    private SalesOrderJpaEntity toEntity(SalesOrder order) {
        SalesOrderJpaEntity entity = new SalesOrderJpaEntity();
        entity.setId(order.getId());
        entity.setCreatedAt(order.getCreatedAt());
        entity.setIdClient(order.getIdClient());
        entity.setIdProduct(order.getIdProduct());
        entity.setStatus(order.getStatus());
        entity.setQuantity(order.getQuantity());
        return entity;
    }

    private SalesOrder toDomain(SalesOrderJpaEntity entity) {
        SalesOrder order = new SalesOrder();
        order.setId(entity.getId());
        order.setCreatedAt(entity.getCreatedAt());
        order.setIdClient(entity.getIdClient());
        order.setIdProduct(entity.getIdProduct());
        order.setStatus(entity.getStatus());
        order.setQuantity(entity.getQuantity());
        return order;
    }
}
