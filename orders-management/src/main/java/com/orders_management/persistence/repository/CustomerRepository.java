package com.orders_management.persistence.repository;

import com.orders_management.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, Integer> {
    @Query(value ="SELECT * FROM customer WHERE id_customer = :idCustomer", nativeQuery = true)
    CustomerEntity getCustomer(int idCustomer);
}
