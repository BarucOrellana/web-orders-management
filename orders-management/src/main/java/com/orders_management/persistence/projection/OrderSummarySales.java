package com.orders_management.persistence.projection;

import java.time.LocalDate;

public interface OrderSummarySales {
    Integer getIdOrder();
    LocalDate getDate();
    String getName();
    String getDestination();
}
