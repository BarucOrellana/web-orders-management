package com.orders_management.persistence.repository;

import com.orders_management.persistence.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRoleRepository extends ListCrudRepository<UserRoleEntity, String> {
    @Query(value = "SELECT role FROM user_rol WHERE username = :username", nativeQuery = true)
    String getUserRole(String username);
}
