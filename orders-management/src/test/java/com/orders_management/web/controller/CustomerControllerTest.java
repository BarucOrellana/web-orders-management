package com.orders_management.web.controller;

import com.orders_management.domain.service.CustomerService;
import com.orders_management.persistence.entity.CustomerEntity;
import com.orders_management.persistence.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

class CustomerControllerTest {

    CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    CustomerService customerService = new CustomerService(customerRepository);
    CustomerController customerController = new CustomerController(customerService);
    CustomerEntity customer = new CustomerEntity();
    @BeforeEach
    public void createCustomers(){
        List<CustomerEntity> customers =  new ArrayList<CustomerEntity>();
        customers.add(new CustomerEntity(1,"Helm de México", null));
        customers.add(new CustomerEntity(2,"Ingredion México", null));
        customers.add(new CustomerEntity(3,"Gapelli", null));
        customers.add(new CustomerEntity(4,"AGR Representaciones", null));
        Mockito.when(customerRepository.findAll()).thenReturn(customers);
        Mockito.when(customerRepository.getCustomer(customer.getIdCustomer())).thenReturn(customer);
        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
    }
    @Test
    void get_all_customers(){
        Assertions.assertEquals(ResponseEntity.ok(customerRepository.findAll()), customerController.getAll());
    }
    @Test
    void get_customers_by_id(){
        customer = new CustomerEntity(6, "General Products", null);
        Assertions.assertEquals(ResponseEntity.ok(customerRepository.getCustomer(6)), customerController.getCustomer(6));
    }
    @Test
    public void save_new_customer() {
        customer = new CustomerEntity(5, "DVA", null);
        Assertions.assertEquals(ResponseEntity.ok(customerRepository.save(customer)), customerController.saveCustomer(customer));
    }
}