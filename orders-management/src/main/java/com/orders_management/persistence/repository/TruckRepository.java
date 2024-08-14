package com.orders_management.persistence.repository;

import com.orders_management.persistence.entity.TruckEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TruckRepository extends ListCrudRepository<TruckEntity, Integer> {
    @Query(value = "SELECT * FROM truck WHERE available = :status", nativeQuery = true)
    List<TruckEntity> getAvailableTruck(boolean status);
    @Query(value = "SELECT * FROM truck WHERE maintenance = :maintenance", nativeQuery = true)
    List<TruckEntity> getMaintenanceTruck(boolean maintenance);
}
