package com.orders_management.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderSalesDto {
    private Integer idOrder;
    private LocalDate date;
    private Integer idDestination;
    private Integer idCustomer;
}
