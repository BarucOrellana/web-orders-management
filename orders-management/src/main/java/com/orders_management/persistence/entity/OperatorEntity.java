package com.orders_management.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "operator")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorEntity {
    @Id
    @Column(name = "id_operator", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOperator;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(columnDefinition = "TINYINT")
    private boolean available;
    @OneToMany(mappedBy = "operator", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderEntity> order;
}
