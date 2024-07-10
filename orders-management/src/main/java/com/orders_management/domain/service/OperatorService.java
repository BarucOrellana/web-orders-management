package com.orders_management.domain.service;

import com.orders_management.persistence.entity.OperatorEntity;
import com.orders_management.persistence.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.server.header.StaticServerHttpHeadersWriter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {
    public final OperatorRepository operatorRepository;

    @Autowired
    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public List<OperatorEntity> getAll(){
        return this.operatorRepository.findAll();
    }
    public List<OperatorEntity> getAvailableOperator(boolean status){
        return this.operatorRepository.getAvailableOperator(status);
    }
    public OperatorEntity save(OperatorEntity operator){
        return this.operatorRepository.save(operator);
    }
    public void delete(OperatorEntity operator){
        this.operatorRepository.delete(operator);
    }
    public boolean exits(int idOperator){
        return this.operatorRepository.existsById(idOperator);
    }
}
