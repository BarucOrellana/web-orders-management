package com.orders_management.persistence.repository;

import com.orders_management.persistence.entity.OrderEntity;
import com.orders_management.persistence.projection.OrderSummaryOperation;
import com.orders_management.persistence.projection.OrderSummarySales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderPagSortRepository extends PagingAndSortingRepository<OrderEntity, Integer> {

    @Query(value = "SELECT o.id_order AS idOrder, o.date AS date, c.name AS name, d.destination AS destination, " +
            "t.number_plate AS numberPlate, op.name AS operatorName, " +
            "o.accepted AS accepted, " +
            "o.finished AS finished " +
            "FROM orders o " +
            "JOIN customer c ON o.id_customer = c.id_customer " +
            "JOIN destination d ON o.id_destination = d.id_destination " +
            "JOIN truck t ON o.id_truck = t.id_truck " +
            "JOIN operator op ON o.id_operator = op.id_operator", nativeQuery = true)
    Page<OrderSummaryOperation> getOrderSummaryOperation(Pageable pageable);

    @Query(value = "SELECT o.id_order AS idOrder, o.date AS date, c.name AS name, d.destination AS destination " +
            "FROM orders o " +
            "JOIN customer c ON o.id_customer = c.id_customer " +
            "JOIN destination d ON o.id_destination = d.id_destination", nativeQuery = true)
    Page<OrderSummarySales> getOrderSummarySales(Pageable pageable);
}
