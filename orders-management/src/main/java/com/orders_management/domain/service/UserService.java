package com.orders_management.domain.service;

import com.orders_management.domain.dto.UserDto;
import com.orders_management.persistence.entity.UserEntity;
import com.orders_management.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String getEmail(UserDto dto){
        Optional<UserEntity> user = this.userRepository.findById(dto.getUsername());
        if (exist(dto.getUsername())){
            return user.get().getEmail();
        }else {
            return "Email no encontrador";
        }
    }
    public boolean exist(String username){
        return this.userRepository.existsById(username);
    }
}