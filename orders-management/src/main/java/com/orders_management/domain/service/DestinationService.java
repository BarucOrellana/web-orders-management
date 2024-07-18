package com.orders_management.domain.service;

import com.orders_management.persistence.entity.DestinationEntity;
import com.orders_management.persistence.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DestinationService {
    public final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }
    public DestinationEntity getDestinationById(int idDestination){
        return this.destinationRepository.getDestinationById(idDestination);
    }
    public DestinationEntity getByDestination(String destination){
        return this.destinationRepository.getByDestination(destination);
    }
    public List<DestinationEntity> getAll(){
        return this.destinationRepository.findAll();
    }
    @Transactional
    public DestinationEntity save(DestinationEntity destination){
        return this.destinationRepository.save(destination);
    }
    public void delete(int idDestination){
        this.destinationRepository.deleteById(idDestination);
    }
    public boolean exits(int idDestination){
        return this.destinationRepository.existsById(idDestination);
    }
}
