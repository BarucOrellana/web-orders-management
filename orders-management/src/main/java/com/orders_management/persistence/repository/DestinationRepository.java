package com.orders_management.persistence.repository;

import com.orders_management.persistence.entity.DestinationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface DestinationRepository extends ListCrudRepository<DestinationEntity, Integer> {
    @Query(value = "SELECT * FROM destination WHERE id_destination = :idDestination", nativeQuery = true)
    DestinationEntity getDestinationById(int idDestination);
    @Query(value = "SELECT * FROM destination WHERE destination = :destination", nativeQuery = true)
    DestinationEntity getByDestination(String destination);
}
