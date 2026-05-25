package com.ecommerce_isil.webapp.core.usecase.port.out;

import com.ecommerce_isil.webapp.core.entity.SalesOrder;

import java.util.Optional;
import java.util.UUID;

public interface SalesOrderRepositoryPort {
    SalesOrder save(SalesOrder salesOrder);

    Optional<SalesOrder> findById(UUID id);

    SalesOrder update(SalesOrder salesOrder);
    void deleteById(UUID idSalesOrder);
}
