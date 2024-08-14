package com.orders_management.web.controller;

import com.orders_management.domain.service.OperatorService;
import com.orders_management.persistence.entity.OperatorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("operator")
public class OperatorController {
    public final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OperatorEntity>> getAll(){
        return ResponseEntity.ok(this.operatorService.getAll());
    }
    @GetMapping("all/{status}")
    public ResponseEntity<List<OperatorEntity>> getAvailableOperator(@PathVariable("status") boolean status){
        return ResponseEntity.ok(this.operatorService.getAvailableOperator(status));
    }
    @PostMapping("new")
    public ResponseEntity<OperatorEntity> saveOperator(@RequestBody OperatorEntity operator){
        if(!this.operatorService.exits(operator.getIdOperator())){
          return ResponseEntity.ok(this.operatorService.save(operator));
        } return ResponseEntity.badRequest().build();
    }
    @PutMapping("update")
    public ResponseEntity<OperatorEntity> updateOperator(@RequestBody OperatorEntity operator){
        if(this.operatorService.exits(operator.getIdOperator())){
            return ResponseEntity.ok(this.operatorService.save(operator));
        } return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("delete")
    public ResponseEntity<OperatorEntity> delete (@RequestBody OperatorEntity operator){
        if(this.operatorService.exits(operator.getIdOperator())){
            this.operatorService.delete(operator);
            return ResponseEntity.ok().build();
        } return ResponseEntity.badRequest().build();
    }
}
