package com.orders_management.web.controller;

import com.orders_management.domain.service.DestinationService;
import com.orders_management.persistence.entity.DestinationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("destination")
public class DestinationController {
    public final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }
    @GetMapping("/id/{idDestination}")
    public ResponseEntity<DestinationEntity> getDestinationById(@PathVariable("idDestination") int idDestination){
        return ResponseEntity.ok(this.destinationService.getDestinationById(idDestination));
    }
    @GetMapping("/all")
    public ResponseEntity<List<DestinationEntity>> getAllDestinations(){
        return ResponseEntity.ok(this.destinationService.getAll());
    }
    @PostMapping("/new")
    public ResponseEntity<DestinationEntity> saveDestination(@RequestBody DestinationEntity destination){
        if(!this.destinationService.exits(destination.getIdDestination())){
            return ResponseEntity.ok(this.destinationService.save(destination));
        }return ResponseEntity.badRequest().build();
    }
    @PutMapping("/update")
    public ResponseEntity<DestinationEntity> updateDestination(@RequestBody DestinationEntity destination){
        if(this.destinationService.exits(destination.getIdDestination())){
            return ResponseEntity.ok(this.destinationService.save(destination));
        }return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/delete/{idDestination}")
    public ResponseEntity<DestinationEntity> deleteDestination(@PathVariable("idDestination") int idDestination){
        if(this.destinationService.exits(idDestination)){
            this.destinationService.delete(idDestination);
            return ResponseEntity.ok().build();
        } return ResponseEntity.badRequest().build();
    }
}
