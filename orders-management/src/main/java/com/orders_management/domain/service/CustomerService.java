package com.orders_management.domain.service;

import com.orders_management.persistence.entity.CustomerEntity;
import com.orders_management.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAll(){
        return this.customerRepository.findAll();
    }
    public CustomerEntity getCustomerById(int idCustomer){
        return this.customerRepository.getCustomer(idCustomer);
    }
    @Transactional
    public CustomerEntity saveCustomer(CustomerEntity customer){
        return this.customerRepository.save(customer);
    }
    public void deleteCustomer(int idCustomer){
        this.customerRepository.deleteById(idCustomer);
    }
    public boolean exits(int idCustomer){
        return this.customerRepository.existsById(idCustomer);
    }
}
