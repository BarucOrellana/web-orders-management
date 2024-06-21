package com.orders_management.persistence.repository;

import com.orders_management.persistence.entity.CustomerEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, Integer> {

}
