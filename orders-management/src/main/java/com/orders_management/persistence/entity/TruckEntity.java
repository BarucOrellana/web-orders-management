package com.orders_management.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "truck")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TruckEntity {
    @Id
    @Column(name = "id_truck", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTruck;
    @Column(name = "number_plate", length = 10, nullable = false)
    private String numberPlate;
    @Column(columnDefinition = "TINYINT")
    private boolean available;
    @Column(columnDefinition = "TINYINT")
    private boolean maintenance;
    @OneToMany(mappedBy = "truck", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderEntity> order;
}
