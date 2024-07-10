package com.orders_management.domain.service;

import com.orders_management.persistence.entity.TruckEntity;
import com.orders_management.persistence.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TruckService {
    private final TruckRepository truckRepository;
    @Autowired
    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<TruckEntity> getAll(){
        return this.truckRepository.findAll();
    }
    public List<TruckEntity> getAvailableTruck(boolean status){
        return this.truckRepository.getAvailableTruck(status);
    }    public List<TruckEntity> getMaintenanceTruck(boolean maintenance){
        return this.truckRepository.getMaintenanceTruck(maintenance);
    }
    @Transactional
    public TruckEntity save(TruckEntity truck){
        return this.truckRepository.save(truck);
    }
    public void delete(TruckEntity truck){
        this.truckRepository.delete(truck);
    }
    public boolean exits(int idTruck){
        return this.truckRepository.existsById(idTruck);
    }
}
