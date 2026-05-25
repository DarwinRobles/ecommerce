package com.ecommerce_isil.webapp.core.usecase.port.in;

import java.util.UUID;

public interface DeleteSalesOrderCase {
    void deleteSalesOrder(UUID idSalesOrder);
}