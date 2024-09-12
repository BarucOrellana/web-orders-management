package com.orders_management.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(length = 50, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(columnDefinition = "TINYINT")
    private boolean locked;
    @Column(columnDefinition = "TINYINT")
    private boolean disable;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles;
}
