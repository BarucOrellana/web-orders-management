package com.orders_management.web.controller;

import com.orders_management.domain.service.TruckService;
import com.orders_management.persistence.entity.TruckEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("truck")
public class TruckController {
    public final TruckService truckService;

    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TruckEntity>> getAll(){
        return ResponseEntity.ok(this.truckService.getAll());
    }
   @GetMapping("all/{status}")
    public ResponseEntity<List<TruckEntity>> getAvailableTruck(@PathVariable("status") boolean status){
        return ResponseEntity.ok(this.truckService.getAvailableTruck(status));
    }
    @GetMapping("all/maintenance/{maintenance}")
    public ResponseEntity<List<TruckEntity>> getMaintenanceTruck(@PathVariable("maintenance") boolean maintenance){
        return ResponseEntity.ok(this.truckService.getMaintenanceTruck(maintenance));
    }
    @PostMapping("new")
    public ResponseEntity<TruckEntity> saveOperator(@RequestBody TruckEntity truck){
        if(!this.truckService.exits(truck.getIdTruck())){
            return ResponseEntity.ok(this.truckService.save(truck));
        } return ResponseEntity.badRequest().build();
    }
    @PutMapping("update")
    public ResponseEntity<TruckEntity> updateOperator(@RequestBody TruckEntity truck){
        if(this.truckService.exits(truck.getIdTruck())){
            if (truck.isMaintenance()){
                truck.setAvailable(false);
            }
            return ResponseEntity.ok(this.truckService.save(truck));
        } return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("delete")
    public ResponseEntity<TruckEntity> delete (@RequestBody TruckEntity truck){
        if(this.truckService.exits(truck.getIdTruck())){
            this.truckService.delete(truck);
            return ResponseEntity.ok().build();
        } return ResponseEntity.badRequest().build();
    }
}
