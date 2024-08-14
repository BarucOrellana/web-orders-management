package com.orders_management.persistence.repository;

import com.orders_management.domain.dto.OrderOperationDto;
import com.orders_management.domain.dto.OrderSalesDto;
import com.orders_management.persistence.entity.OrderEntity;
import com.orders_management.persistence.projection.OrderSummaryOperation;
import com.orders_management.persistence.projection.OrderSummarySales;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    @Query(value = "UPDATE orders "+
    "SET id_truck = :#{#dto.idTruck}, "+
    "id_operator = :#{#dto.idOperator}, "+
    "accepted = :#{#dto.accepted}, "+
    "finished = :#{#dto.finished} "+
    "WHERE id_order = :#{#dto.idOrder}", nativeQuery = true)
    @Modifying
    void updateOrderOperation(OrderOperationDto dto);
    @Query(value = "UPDATE orders "+
            "SET date = :#{#dto.date}, "+
            "id_destination = :#{#dto.idDestination}, "+
            "id_customer = :#{#dto.idCustomer} "+
            "WHERE id_order = :#{#dto.idOrder}", nativeQuery = true)
    @Modifying
    void updateOrderSales(OrderSalesDto dto);
}
