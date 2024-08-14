package com.orders_management.domain.service;

import com.orders_management.domain.dto.OrderOperationDto;
import com.orders_management.domain.dto.OrderSalesDto;
import com.orders_management.persistence.entity.OrderEntity;
import com.orders_management.persistence.projection.OrderSummaryOperation;
import com.orders_management.persistence.projection.OrderSummarySales;
import com.orders_management.persistence.repository.OrderPagSortRepository;
import com.orders_management.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderPagSortRepository orderPagSortRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderPagSortRepository orderPagSortRepository) {
        this.orderRepository = orderRepository;
        this.orderPagSortRepository = orderPagSortRepository;
    }
    public Page<OrderEntity> getAll(int page, int elements){
        Pageable pageable = PageRequest.of(page, elements);
        return this.orderPagSortRepository.findAll(pageable);
    }
    public Optional<OrderEntity> getOrderById(int idOrder){
        return this.orderRepository.findById(idOrder);
    }
    public Page<OrderSummaryOperation> getSummaryOperation(int i, int x){
        Pageable pageRequest = PageRequest.of(i,x);
        return this.orderPagSortRepository.getOrderSummaryOperation(pageRequest);
    }
    public Page<OrderSummarySales> getSummarySales(int i, int x){
        Pageable pageRequest = PageRequest.of(i,x);
        return this.orderPagSortRepository.getOrderSummarySales(pageRequest);
    }
    @Transactional
    public OrderEntity save(OrderEntity order){
        return this.orderRepository.save(order);
    }
    @Transactional
    public void updateOrderOperation(OrderOperationDto dto){
        this.orderRepository.updateOrderOperation(dto);
    }
    @Transactional
    public void updateOrderSales(OrderSalesDto dto){
        this.orderRepository.updateOrderSales(dto);
    }
    public void delete(int idOrder){
        this.orderRepository.deleteById(idOrder);
    }
    public boolean exist(int idOrder){
        return this.orderRepository.existsById(idOrder);
    }
}
