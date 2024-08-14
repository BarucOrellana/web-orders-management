package com.orders_management.persistence.projection;

import java.time.LocalDate;

public interface OrderSummaryOperation {
    Integer getIdOrder();
    LocalDate getDate();
    String getName();
    String getDestination();
    String getNumberPlate();
    String getOperatorName();
    Byte getAccepted();
    Byte getFinished();
}
