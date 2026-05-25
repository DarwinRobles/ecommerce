package com.ecommerce_isil.webapp.infrastructure.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateSalesOrderRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.SalesOrderResponse;
import com.ecommerce_isil.webapp.core.usecase.service.SalesOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/orders")
public class SalesOrderController {

    private final SalesOrderService salesOrderService;
    //constructor
    public SalesOrderController(SalesOrderService salesOrderService){
        this.salesOrderService=salesOrderService;

    }
    @PostMapping
    public SalesOrderResponse createOrder(@RequestBody CreateSalesOrderRequest request){
        return  salesOrderService.createSalesOrder(request);

    }








}
