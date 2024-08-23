package com.orders_management.domain.service;

import com.orders_management.domain.dto.UserDto;
import com.orders_management.persistence.entity.UserEntity;
import com.orders_management.persistence.entity.UserRoleEntity;
import com.orders_management.persistence.repository.UserRepository;
import com.orders_management.persistence.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }
    public String getEmail(UserDto dto){
        Optional<UserEntity> user = this.userRepository.findById(dto.getUsername());
        if (exist(dto.getUsername())){
            return user.get().getEmail();
        }else {
            return "Email not found";
        }
    }
    public String getRole(UserDto dto) {
        if (exist(dto.getUsername())) {
            return this.userRoleRepository.getUserRole(dto.getUsername());
        } else {
            return "Role not found";
        }
    }
    public boolean exist(String username){
        return this.userRepository.existsById(username);
    }
}