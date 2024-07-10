package com.orders_management.persistence.repository;

import com.orders_management.persistence.entity.OperatorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface OperatorRepository extends ListCrudRepository<OperatorEntity, Integer> {
    @Query(value = "SELECT * FROM operator WHERE available = :status", nativeQuery = true)
    List<OperatorEntity> getAvailableOperator(boolean status);
}
