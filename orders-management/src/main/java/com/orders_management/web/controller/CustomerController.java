package com.orders_management.web.controller;

import com.orders_management.domain.service.CustomerService;
import com.orders_management.persistence.entity.CustomerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAll(){
        return ResponseEntity.ok(this.customerService.getAll());
    }
    @GetMapping("/{id_customer}")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable("id_customer") int idCustomer ){
        return ResponseEntity.ok(this.customerService.getCustomerById(idCustomer));
    }
    @PostMapping("/new-customer")
    public ResponseEntity<CustomerEntity> saveCustomer(@RequestBody CustomerEntity customer){
        if(!this.customerService.exits(customer.getIdCustomer())) {
            return ResponseEntity.ok(this.customerService.saveCustomer(customer));
        }
        return ResponseEntity.badRequest().build();
    }
}
