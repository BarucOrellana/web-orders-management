package com.orders_management.web.controller;

import com.orders_management.domain.dto.OrderOperationDto;
import com.orders_management.domain.dto.OrderSalesDto;
import com.orders_management.domain.service.OrderService;
import com.orders_management.persistence.entity.OrderEntity;
import com.orders_management.persistence.projection.OrderSummaryOperation;
import com.orders_management.persistence.projection.OrderSummarySales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<OrderEntity>> getAll(@RequestParam int page, @RequestParam int elements) {
        return ResponseEntity.ok(this.orderService.getAll(page, elements));
    }
    @GetMapping("/{idOrder}")
    public ResponseEntity<Optional<OrderEntity>> getOrderById(@PathVariable("idOrder") int idOrder) {
        if (this.orderService.exist(idOrder)) {
            return ResponseEntity.ok(this.orderService.getOrderById(idOrder));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/summary/operation")
    public ResponseEntity<Page<OrderSummaryOperation>> getSummaryOperation(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int elements) {
        return ResponseEntity.ok(this.orderService.getSummaryOperation(page, elements));
    }
    @GetMapping("/summary/sales")
    public ResponseEntity<Page<OrderSummarySales>> getSummarySales(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int elements){
        return ResponseEntity.ok(this.orderService.getSummarySales(page, elements));
    }
    @PostMapping("/save")
    public ResponseEntity<OrderEntity> save(@RequestBody OrderEntity order) {
        if (!this.orderService.exist(order.getIdOrder())) {
            return ResponseEntity.ok(this.orderService.save(order));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/operation/update")
    public ResponseEntity<OrderEntity> updateOrderOperation(@RequestBody OrderOperationDto order) {
        if (this.orderService.exist(order.getIdOrder())) {
            this.orderService.updateOrderOperation(order);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/sales/update")
    public ResponseEntity<OrderEntity> updateOrderSales(@RequestBody OrderSalesDto order) {
        if (this.orderService.exist(order.getIdOrder())) {
            this.orderService.updateOrderSales(order);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/update")
    public ResponseEntity<OrderEntity> update(@RequestBody OrderEntity order){
        if(this.orderService.exist(order.getIdOrder())) {
            return ResponseEntity.ok(this.orderService.save(order));
        }return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/delete/{idOrder}")
    public ResponseEntity<OrderEntity> delete(@PathVariable("idOrder") int idOrder){
        if (this.orderService.exist(idOrder)){
            this.orderService.delete(idOrder);
            return ResponseEntity.ok().build();
        }return ResponseEntity.badRequest().build();
    }
}
