package com.orders_management.domain.dto;

import lombok.Data;

@Data
public class OrderOperationDto {
    private Integer idOrder;
    private Integer idTruck;
    private Integer idOperator;
    private boolean accepted;
    private boolean finished;
}
